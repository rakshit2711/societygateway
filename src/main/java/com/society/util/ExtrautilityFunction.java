package com.society.util;

import java.util.List;
import java.util.Objects;

public class ExtrautilityFunction {

	public static <T>  boolean isEmptyorNonNull(List<T> list) {
		return Objects.nonNull(list) && !list.isEmpty();
	}

}
