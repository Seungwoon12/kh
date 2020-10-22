package oop.multi2;

//가수 인터페이스
public interface Singer {
	//노래기능 : 가수가 노래를 부르는 건 맞는데 어떻게 부르는지는 가수마다 다르다(추상)
	void sing();
	//댄스기능
	void dance();
}
