package genericSerDeser.util;

import genericSerDeser.fileOperations.Logger;
import genericSerDeser.fileOperations.Logger.DebugLevel;

public class First {
	private boolean booleanValue;
	private byte byteValue;
	private char charValue;
	private double doubleValue;
	private float floatValue;
	private int intValue;
	private long longValue;
	private short shortValue;
	private String stringValue;
	
	/**
	 * Constructor
	 */
	public First() {
		Logger.writeMessage("First Constructor is called ", DebugLevel.CONSTRUCTOR);
		byteValue = 0;
		shortValue = 0;
		intValue = 0;
		longValue = 0L;
		floatValue = 0.0f;
		doubleValue = 0.0d;
		booleanValue = false;
		charValue = '\u0000';
		stringValue = null;
	}

	public byte getByteValue() {
		return byteValue;
	}

	public void setByteValue(byte byteValueIn) {
		byteValue = byteValueIn;
	}

	public short getShortValue() {
		return shortValue;
	}

	public void setShortValue(short shortValueIn) {
		shortValue = shortValueIn;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValueIn) {
		intValue = intValueIn;
	}

	public long getLongValue() {
		return longValue;
	}

	public void setLongValue(long longValueIn) {
		longValue = longValueIn;
	}

	public float getFloatValue() {
		return floatValue;
	}

	public void setFloatValue(float floatValueIn) {
		floatValue = floatValueIn;
	}

	public double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(double doubleValueIn) {
		doubleValue = doubleValueIn;
	}

	public boolean getBooleanValue() {
		return booleanValue;
	}

	public void setBooleanValue(boolean booleanValueIn) {
		booleanValue = booleanValueIn;
	}

	public char getCharValue() {
		return charValue;
	}

	public void setCharValue(char charValueIn) {
		charValue = charValueIn;
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
		result = prime * result + (booleanValue ? 1231 : 1237);
		result = prime * result + byteValue;
		result = prime * result + charValue;
		long temp;
		temp = Double.doubleToLongBits(doubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(floatValue);
		result = prime * result + intValue;
		result = prime * result + (int) (longValue ^ (longValue >>> 32));
		result = prime * result + shortValue;
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
		First other = (First) obj;
		if (booleanValue != other.booleanValue)
			return false;
		if (byteValue != other.byteValue)
			return false;
		if (charValue != other.charValue)
			return false;
		if (Double.doubleToLongBits(doubleValue) != Double.doubleToLongBits(other.doubleValue))
			return false;
		if (Float.floatToIntBits(floatValue) != Float.floatToIntBits(other.floatValue))
			return false;
		if (intValue != other.intValue)
			return false;
		if (longValue != other.longValue)
			return false;
		if (shortValue != other.shortValue)
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
		return "First [byteValue=" + byteValue + ", shortValue=" + shortValue + ", intValue=" + intValue
				+ ", longValue=" + longValue + ", floatValue=" + floatValue + ", doubleValue=" + doubleValue
				+ ", booleanValue=" + booleanValue + ", charValue=" + charValue + ", stringValue=" + stringValue + "]";
	}
	
}