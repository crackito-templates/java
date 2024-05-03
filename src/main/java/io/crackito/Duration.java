package io.crackito;

public class Duration {

	final int hour,minute, second;
	public Duration(int hour, int minute, int second) throws  IllegalArgumentException{
		if (hour < 0 ||minute < 0 || minute > 59 || second < 0 || second > 59 ) {
			throw new IllegalArgumentException("Incorrect value");
		}
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour(){
		return this.hour;
	}
	public int getMinute(){
		return this.minute;
	}

	public int getSecond() {
		return this.second;
	}

	public boolean equal(Duration d){
		return this.hour == d.hour && this.minute == d.minute && this.second == d.second;
	}

	public Duration addOneSeconde(){
		if(this.second < 59){
			return new Duration(this.hour, this.minute, this.second + 1);
		}
		else if(this.minute < 59){
			return new Duration(this.hour,this.minute + 1,0);
		}
		else{
			return new Duration(this.hour +1,0,0);
		}

	}

	public boolean lower(Duration d){
		if(this.hour < d.hour){
			return true;
		}
		else if(this.hour == d.hour && this.minute < d.minute){
			return true;
		}
		else if(this.hour == d.hour && this.minute == d.minute && this.second < d.second){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return  hour + ":" + minute + ":" + second;
	}


}