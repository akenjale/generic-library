package genericSerDeser.strategy;

public interface SerializationStrategy {
	String createDPMLFormat(Object obj);
}
