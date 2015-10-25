package com.gaby;

import java.util.List;

public class Scoring {

	//iterates through hand, adding points based on card values
	public static int getScore(List<Card> playerHand) {
		int i;
		int score = 0;
		for(i=1; i < playerHand.size(); i++){
			if(playerHand.get(i).number=="Ace"){
				score += 1;}
			if(playerHand.get(i).number=="2"){
				score += 2;}
			if(playerHand.get(i).number=="3"){
				score += 3;}
			if(playerHand.get(i).number=="4"){
				score += 4;}
			if(playerHand.get(i).number=="5"){
				score += 5;}
			if(playerHand.get(i).number=="6"){
				score += 6;}
			if(playerHand.get(i).number=="7"){
				score += 7;}
			if(playerHand.get(i).number=="8"){
				score += 8;}
			if(playerHand.get(i).number=="9"){
				score += 9;}
			if(playerHand.get(i).number=="10"){
				score += 10;}
			if(playerHand.get(i).number=="Jack"){
				score += 10;}
			if(playerHand.get(i).number=="Queen"){
				score += 10;}
			if(playerHand.get(i).number=="King"){
				score += 10;}
			}
		
		return score;

	}
}
