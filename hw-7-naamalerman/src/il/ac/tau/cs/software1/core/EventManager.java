package il.ac.tau.cs.software1.core;

import java.util.*;

public class EventManager {
	Map<String, List<EventSubscription>> subscribers = new HashMap<>();
	private static EventManager instance;
	
	public void subscribe(String event, GameObject subscriber, IEventCallback callback) {
		if (!subscribers.containsKey(event)) {
			subscribers.put(event, new ArrayList<EventSubscription>());
		}
		
		List<EventSubscription> lstEventSub = subscribers.get(event);
		lstEventSub.add(new EventSubscription(subscriber,callback));
		subscribers.put(event, lstEventSub);
	}
	
	public void notifyEvent(String event, GameObject publisher, Object data) {
		if (subscribers.containsKey(event)) {
			List<EventSubscription> lstEventSub = subscribers.get(event);
			for(EventSubscription eventSub:lstEventSub) {
				EventData eventData = new EventData(publisher, data);
				eventSub.callback.call(eventData);
			}	
		}
	}
	
	public static EventManager getInstance() {
		if (instance==null) {
			instance = new EventManager();
		}
		return instance;
		
	}
}
