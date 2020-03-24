package com.think.generic;

import java.util.List;

/**
 * 更过泛型边界 应用于继承 的示例
 * @author luQl
 *
 */
	//超级能量 太阳
	interface SuperPower{}
	//X射线
	interface XRayVision extends SuperPower{
		//穿墙能力
		void seeThroughtWalls();
	}
	//超声波
	interface SuperHearing extends SuperPower{
		//听见微妙的声音能力
		void hearSubtleNoises();
	}
	//超级嗅觉
	interface SuperSmell extends SuperPower{
		//追踪气味能力
		void trackBySmell();
	}
	//一个超级英雄
	class SuperHero<POWER extends SuperPower>{
		POWER power;
		SuperHero(POWER power){
			this.power = power;
		}
		//获取具体的超级英雄
		POWER getPower() {return power;}
	}
	//超级侦探  ，边界拥有X射线能力，并且是超级英雄的一种
	class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER>{
		public SuperSleuth(POWER power) {super(power);}
		void see() {power.seeThroughtWalls();}
	}
	//哮天犬 类行 ，边界是拥有超级听力和超级嗅觉 ，也是超级英雄的一种
	class  CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER>{
		public CanineHero(POWER power) {
			super(power);
		}
		//拥有听和嗅的能力
		void hear() {power.hearSubtleNoises();}
		void smell() {power.trackBySmell();}
		}
	//拥有超级听和嗅 的一类 
	class SuperHearSmell implements SuperHearing ,SuperSmell{
		//可以听见微妙的声音
		public void hearSubtleNoises() {};
		//可以追踪气味
		public void trackBySmell() {
		};
	}
	
	//狼人 ，犬齿类的一种 ，具有超级听和嗅
	class DogBoy extends CanineHero<SuperHearSmell>{
		DogBoy(){super(new SuperHearSmell());}
	}
	
	//世界大战
	public class EpicBattle 
	{
		static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
			hero.getPower().hearSubtleNoises();
		}
		
		static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
			hero.getPower().hearSubtleNoises();
			hero.getPower().trackBySmell();
		}
		
		public static void main(String[] args) {
			DogBoy dogBoy = new DogBoy();
			useSuperHearing(dogBoy);
			superFind(dogBoy);
			//you can do this
			List<? extends SuperHearing> audioBoys;
			//but you can't do this
			//List<? extends SuperHearing & SuperSmell> dogBoys;
			
					
		}
	}
	//TODOD ......

