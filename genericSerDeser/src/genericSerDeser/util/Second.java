package genericSerDeser.util;

import genericSerDeser.fileOperations.Logger;
import genericSerDeser.fileOperations.Logger.DebugLevel;

public class Second {
	private double doubleValue;
	private double doubleValue2;
	private long longValue;
	private long longValue2;
	private short shortValue;
	private short shortValue2;
	private String stringValue;
	
	/**
	 * Constructor
	 */
	public Second() {
		Logger.writeMessage("Second Constructor is called ", DebugLevel.CONSTRUCTOR);
		shortValue = 0;
		shortValue2 = 0;
		longValue = 0L;
		longValue2 = 0L;
		doubleValue = 0.0d;
		doubleValue2 = 0.0d;
		stringValue = null;
	}

	public short getShortValue() {
		return shortValue;
	}

	public void setShortValue(short shortValueIn) {
		shortValue = shortValueIn;
	}

	public short getShortValue2() {
		return shortValue2;
	}

	public void setShortValue2(short shortValue2In) {
		shortValue2 = shortValue2In;
	}

	public long getLongValue() {
		return longValue;
	}

	public void setLongValue(long longValueIn) {
		longValue = longValueIn;
	}

	public long getLongValue2() {
		return longValue2;
	}

	public void setLongValue2(long longValue2In) {
		longValue2 = longValue2In;
	}

	public double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(double doubleValueIn) {
		doubleValue = doubleValueIn;
	}

	public double getDoubleValue2() {
		return doubleValue2;
	}

	public void setDoubleValue2(double doubleValue2In) {
		doubleValue2 = doubleValue2In;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValueIn) {
		stringValue = stringValueIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(doubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(doubleValue2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (longValue ^ (longValue >>> 32));
		result = prime * result + (int) (longValue2 ^ (longValue2 >>> 32));
		result = prime * result + shortValue;
		result = prime * result + shortValue2;
		result = prime * result + ((stringValue == null) ? 0 : stringValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Second other = (Second) obj;
		if (Double.doubleToLongBits(doubleValue) != Double.doubleToLongBits(other.doubleValue))
			return false;
		if (Double.doubleToLongBits(doubleValue2) != Double.doubleToLongBits(other.doubleValue2))
			return false;
		if (longValue != other.longValue)
			return false;
		if (longValue2 != other.longValue2)
			return false;
		if (shortValue != other.shortValue)
			return false;
		if (shortValue2 != other.shortValue2)
			return false;
		if (stringValue == null) {
			if (other.stringValue != null)
				return false;
		} else if (!stringValue.equals(other.stringValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Second [shortValue=" + shortValue + ", shortValue2=" + shortValue2 + ", longValue=" + longValue
				+ ", longValue2=" + longValue2 + ", doubleValue=" + doubleValue + ", doubleValue2=" + doubleValue2
				+ ", stringValue=" + stringValue + "]";
	}
		
}
