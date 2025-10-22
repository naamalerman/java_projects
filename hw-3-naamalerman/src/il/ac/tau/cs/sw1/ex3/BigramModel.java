package il.ac.tau.cs.sw1.ex3;

import java.io.IOException;
import java.io.*;	

public class BigramModel {
	public static final int MAX_VOCABULARY_SIZE = 14500;
	public static final String VOC_FILE_SUFFIX = ".voc";
	public static final String COUNTS_FILE_SUFFIX = ".counts";
	public static final String SOME_NUM = "some_num";
	public static final int ELEMENT_NOT_FOUND = -1;
	
	String[] mVocabulary;
	int[][] mBigramCounts;
	// DO NOT CHANGE THIS !!! 
	public void initModel(String fileName) throws IOException{
		mVocabulary = buildVocabularyIndex(fileName);
		mBigramCounts = buildCountsArray(fileName, mVocabulary);
		
	}
	
	/*
	 * @post: mVocabulary = prev(mVocabulary)
	 * @post: mBigramCounts = prev(mBigramCounts)
	 */
	public String[] buildVocabularyIndex(String fileName) throws IOException{ // Q 1

		String[] result = new String[MAX_VOCABULARY_SIZE];

		File fromFile = new File(fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile));
		String line;
		int i = 0;
		while ((line = bufferedReader.readLine()) != null) {
			String[] lineWords = line.split("\\s+");
			int j = 0;
			while (i<MAX_VOCABULARY_SIZE && j<lineWords.length) {
				String str = handleWord(lineWords[j]);
				boolean found = false;
				if (str.length()>0) {
					int p=0;
					while (!found && p<result.length && result[p]!=null) {
						if (str.equals(result[p])) {
							found = true;
						}
						p++;
					}
					if (!found) {
						result[i]=str;
						i++;
					}	
				}
				j++;
			}
		}
		
		bufferedReader.close();
		
		String[] Vocabulary = new String[i];
        for (int j = 0; j < i; j++) {
        	Vocabulary[j] = result[j];
        }
		return Vocabulary;
	}
	
	
	public String handleWord(String str) {
		String charValid = "abcdefghijklmnopqrstuvwxyz";
		boolean numFlag = true;
		str = str.toLowerCase();
		for (char c: str.toCharArray()) {
			if (charValid.contains(String.valueOf(c))) {
				return str;
			}
		}
		for (int i=0; i<str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)) && numFlag) {
				numFlag = false;
			}
		}
		if (numFlag && str.length()>0) {
			return SOME_NUM;
		}
		return "";
		
	}
	
	
	/*
	 * @post: mVocabulary = prev(mVocabulary)
	 * @post: mBigramCounts = prev(mBigramCounts)
	 */
	public int[][] buildCountsArray(String fileName, String[] vocabulary) throws IOException{ // Q - 2
		File fromFile = new File(fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile));
		String line;
		int[][] bigramCount = new int[vocabulary.length][vocabulary.length];
		while ((line = bufferedReader.readLine()) != null) {
			String[] lineWords = line.split("\\s+");
			int j = 0;
			int prevWord = -1;
			while (j<lineWords.length) {
				String str = handleWord(lineWords[j]);
				int currWord = findIndex(str, vocabulary);
				if (currWord!=-1 && prevWord!=-1) {
					bigramCount[prevWord][currWord]++;
				}
				prevWord = currWord;
				j++;
			}
		}
		
		bufferedReader.close();
		return bigramCount;
	}
	
	public int findIndex(String str, String[] vocabulary) {
		for (int i=0;i<vocabulary.length;i++) {
			if (vocabulary[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * @pre: the method initModel was called (the language model is initialized)
	 * @pre: fileName is a legal file path
	 */
	public void saveModel(String fileName) throws IOException{ // Q-3
		FileWriter writerVoc = new FileWriter(fileName+VOC_FILE_SUFFIX);
		writerVoc.write(mVocabulary.length+" words\n");
        for (int i=0; i<mVocabulary.length;i++) {
        	writerVoc.write(i+","+mVocabulary[i]+"\n");
        }
        
        FileWriter writerCount = new FileWriter(fileName+COUNTS_FILE_SUFFIX);
        for (int i = 0; i < mBigramCounts.length; i++) {          
            for (int j = 0; j < mBigramCounts[i].length; j++) {   
            	if (mBigramCounts[i][j]!=0) {
            		writerCount.write(i+","+j+":"+mBigramCounts[i][j]+"\n");
            	}
            }
        }
        writerVoc.close();
        writerCount.close();
	}
	
	
	/*
	 * @pre: fileName is a legal file path
	 */
	public void loadModel(String fileName) throws IOException{ // Q - 4
		String line;
		File fromFileVoc = new File(fileName+VOC_FILE_SUFFIX);
		BufferedReader bufferedReaderVoc = new BufferedReader(new FileReader(fromFileVoc));
		line = bufferedReaderVoc.readLine();
		String length = line.split(" ")[0];
		mVocabulary = new String[Integer.parseInt(length)];
		while ((line = bufferedReaderVoc.readLine()) != null) {
			String[] indexWord = line.split(",");
			mVocabulary[Integer.parseInt(indexWord[0])] = indexWord[1];
		}
		
		File fromFileCounts = new File(fileName+COUNTS_FILE_SUFFIX);
		BufferedReader bufferedReaderCounts = new BufferedReader(new FileReader(fromFileCounts));
		mBigramCounts = new int[Integer.parseInt(length)][Integer.parseInt(length)];
		while ((line = bufferedReaderCounts.readLine()) != null) {
			String[] indexCount = line.split(":");
			String[] index = (indexCount[0]).split(",");
			mBigramCounts[Integer.parseInt(index[0])][Integer.parseInt(index[1])] = Integer.parseInt(indexCount[1]);
		}
		
		bufferedReaderVoc.close();
		bufferedReaderCounts.close();
	}

	
	
	/*
	 * @pre: word is in lowercase
	 * @pre: the method initModel was called (the language model is initialized)
	 * @post: $ret = -1 if word is not in vocabulary, otherwise $ret = the index of word in vocabulary
	 */
	public int getWordIndex(String word){  // Q - 5
		for (int i=0;i<mVocabulary.length;i++) {
			if (mVocabulary[i].equals(word)) {
				return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	
	
	/*
	 * @pre: word1, word2 are in lowercase
	 * @pre: the method initModel was called (the language model is initialized)
	 * @post: $ret = the count for the bigram <word1, word2>. if one of the words does not
	 * exist in the vocabulary, $ret = 0
	 */
	public int getBigramCount(String word1, String word2){ //  Q - 6
		int word1Index=ELEMENT_NOT_FOUND;
		int word2Index=ELEMENT_NOT_FOUND;
		
		for (int i=0;i<mVocabulary.length;i++) {
			if(mVocabulary[i].equals(word1)) {
				word1Index=i;
			}
			if(mVocabulary[i].equals(word2)) {
				word2Index=i;
			}
		}
		if(word1Index!=ELEMENT_NOT_FOUND && word2Index!=ELEMENT_NOT_FOUND) {
			return mBigramCounts[word1Index][word2Index];
		}
		return 0;
	}
	
	
	/*
	 * @pre word in lowercase, and is in mVocabulary
	 * @pre: the method initModel was called (the language model is initialized)
	 * @post $ret = the word with the lowest vocabulary index that appears most fequently after word (if a bigram starting with
	 * word was never seen, $ret will be null
	 */
	public String getMostFrequentProceeding(String word){ //  Q - 7
		int wordIndex=ELEMENT_NOT_FOUND;
		for (int i=0;i<mVocabulary.length;i++) {
			if(mVocabulary[i].equals(word)) {
				wordIndex=i;
			}
		}
		
		if (wordIndex==ELEMENT_NOT_FOUND) {
			return null;
		}
		
		int max = 0;
		int maxIndex = ELEMENT_NOT_FOUND;
		for (int i=0;i<mBigramCounts.length;i++) {
			if (mBigramCounts[wordIndex][i]>max) {
				max=mBigramCounts[wordIndex][i];
				maxIndex=i;
			}
		}
		if (maxIndex==ELEMENT_NOT_FOUND) {
			return null;
		}
		return mVocabulary[maxIndex];
	}
	
	
	/* @pre: sentence is in lowercase
	 * @pre: the method initModel was called (the language model is initialized)
	 * @pre: each two words in the sentence are are separated with a single space
	 * @post: if sentence is is probable, according to the model, $ret = true, else, $ret = false
	 */
	public boolean isLegalSentence(String sentence){  //  Q - 8

		String[] allSentence = sentence.split("\\s+");
		if (allSentence.length==1) {
			if (allSentence[0] == "" || getWordIndex(allSentence[0])!=-1) {
				return true;
			}
			return false;
		}
		for (int i=0; i<allSentence.length-1;i++) {
			int wordsCount = getBigramCount(allSentence[i],allSentence[i+1]);
			if(wordsCount==0) {
				return false;
			}
		}
		return true;
	}
	
	
	
	/*
	 * @pre: arr1.length = arr2.legnth
	 * post if arr1 or arr2 are only filled with zeros, $ret = -1, otherwise calcluates CosineSim
	 */
	public static double calcCosineSim(int[] arr1, int[] arr2){ //  Q - 9
		int ab = 0;
		int a = 0;
		int b = 0;
		
		for (int i=0;i<arr1.length;i++) {
			ab+=(arr1[i]*arr2[i]);
			a+=(arr1[i]*arr1[i]);
			b+=(arr2[i]*arr2[i]);
		}
		if (a==0 || b==0) {
			return -1.;
		}
		return (ab/(Math.sqrt(a)*Math.sqrt(b)));
	}

	
	/*
	 * @pre: word is in vocabulary
	 * @pre: the method initModel was called (the language model is initialized), 
	 * @post: $ret = w implies that w is the word with the largest cosineSimilarity(vector for word, vector for w) among all the
	 * other words in vocabulary
	 */
	public String getClosestWord(String word){ //  Q - 10
		int wordIndex = getWordIndex(word);
		double maxVector = 0.0;
		int maxVectorIndex = 0;
		for (int i=0;i<mBigramCounts.length;i++) {
			if (i!=wordIndex) {
				double score = calcCosineSim(mBigramCounts[wordIndex],mBigramCounts[i]);
				if (score>maxVector) {
					maxVector=score;
					maxVectorIndex=i;
				}
			}
		}
		
		return mVocabulary[maxVectorIndex];
	}

	
}
