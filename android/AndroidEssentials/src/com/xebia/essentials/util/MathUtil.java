package com.xebia.essentials.util;

import java.util.Random;

import com.google.common.base.Preconditions;

public class MathUtil {
	
	public static int randInt(int minInclusive, int maxExclusive) {
		
		Preconditions.checkArgument(minInclusive >= 0 );
		Preconditions.checkArgument(maxExclusive >= minInclusive );

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is  exclusive of the top value,
	    int randomNum = rand.nextInt((maxExclusive - minInclusive)) + minInclusive;

	    return randomNum;
	}
	

}
