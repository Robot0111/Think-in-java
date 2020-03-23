package com.think.generic;

/**
 * 更过泛型边界 应用于继承 的示例
 * @author luQl
 *
 */
public class EpicBattle 
{
	interface SuperPower{}
	
	interface XRayVision extends SuperPower{
		void seeThroughtWalls();
	}
	
	interface SuperHearing extends SuperPower{
		void hearSubtleNoises();
	}
	
	interface SuperSmell extends SuperPower{
		void trackBySmell();
	}
	
	class SuperHero<POWER extends SuperPower>{
		POWER power;
		SuperHero(POWER power){
			this.power = power;
		}
		POWER gerPower() {return power;}
	}
	
	class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER>{
		public SuperSleuth(POWER power) {super(power);}
		void see() {power.seeThroughtWalls();}
	}
	
	//TODOD ......
}
