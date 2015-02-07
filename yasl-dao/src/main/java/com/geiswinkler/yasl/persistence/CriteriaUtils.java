package com.geiswinkler.yasl.persistence;

import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

import static org.apache.commons.lang.StringUtils.deleteWhitespace;
import static org.apache.commons.lang.StringUtils.isBlank;

public class CriteriaUtils {

	public static boolean isNotFilledCriteria(String criteria) {
		return isBlank(criteria) || deleteWhitespace(criteria).replace("*", "").replace("%", "").length() < 1;
	}

	public static boolean isFilledCriteria(String criteria) {
		return !isNotFilledCriteria(criteria);
	}

	public static <T> boolean isNotFilledCriteria(Collection<T> criteriaList) {
		return criteriaList == null || criteriaList.isEmpty();
	}

	public static <T> boolean isFilledCriteria(Collection<T> criteriaList) {
		return !isNotFilledCriteria(criteriaList);
	}

	public static boolean isNotFilledCriteria(Integer number) {
		return number == null || number.equals(0);
	}

	public static boolean isFilledCriteria(Integer number) {
		return !isNotFilledCriteria(number);
	}

	public static boolean isProperILilkeInteger(String number, int maxLength) {
		return number != null && prepareIntegerForLike(number.trim(), maxLength) != null;
	}

	public static String prepareContainsStringLowerCase(String searchString) {
		if (searchString != null) {
			return prepareContainsString(searchString.toLowerCase());
		} else {
			return "*";
		}
	}

	public static String prepareContainsString(String searchString) {
		return prepareSearchString("*" + searchString.trim() + "*");
	}

	public static String prepareStartsWithString(String searchString) {
		return prepareSearchString(searchString.trim() + "*");
	}

	public static String prepareSearchString(String searchString) {
		// Remove invalid wildcard first, than replace wildcard * with '%' for us in sql
		String search = searchString.replace("%", "").replace('*', '%');
		return search.trim();
	}

	/**
	 * Resets the time of the date to the begin of the day.
	 * 
	 * @param date
	 * @param timeZone
	 *            TODO
	 * @return
	 */
	public static Date prepareBeginSearchDate(Date date, TimeZone timeZone) {
		// DateTime localTime = new DateTime(date, DateTimeZone.forTimeZone(timeZone));
		// return localTime.toDateMidnight().toDate();
		// FIXME
		return date;
	}

	/**
	 * Resets the time of the date to the end of the day.
	 * 
	 * @param date
	 * @param timeZone
	 *            TODO
	 * @return
	 */
	public static Date prepareEndSearchDate(Date date, TimeZone timeZone) {
		// DateTime dayBegin = new DateTime(prepareBeginSearchDate(date, timeZone));
		// DateTime endDate = dayBegin.plusHours(24).minusMillis(1);
		// return endDate.toDate();
		// FIXME
		return date;
	}

	public static ILikeInteger prepareIntegerForLike(String searchString, int maxLength) {
		searchString = prepareSearchString(searchString);
		int number = -1;

		if (StringUtils.isNotEmpty(searchString) && StringUtils.isNumeric(searchString)) {
			number = Integer.parseInt(searchString);
			return new ILikeInteger(number);
		} else if (searchString.endsWith("%")) {
			String idSearch = searchString.replace("%", "");
			if (StringUtils.isNotEmpty(searchString) && StringUtils.isNumeric(idSearch)) {
				int missingZeros = maxLength - idSearch.length();
				for (int i = 0; i < missingZeros; i++) {
					idSearch = idSearch + "0";
				}
				number = Integer.parseInt(idSearch);

				String maxDigits = (Integer.parseInt(idSearch.charAt(0) + "") + 1) + "";
				for (int i = 0; i < maxLength - 1; i++) {
					maxDigits += "0";
				}
				int maxNumber = Integer.parseInt(maxDigits);
				return new ILikeInteger(number, maxNumber);
			}
		}

		return null;
	}

	public static class ILikeInteger {
		private int number;
		private Integer maxNumber;

		private ILikeInteger(int number) {
			this.number = number;
		}

		private ILikeInteger(int number, int maxNumber) {
			this(number);
			this.maxNumber = maxNumber;
		}

		public int getNumber() {
			return number;
		}

		public int getMaxNumber() {
			return maxNumber;
		}

		public boolean isUseExactMatch() {
			return maxNumber == null;
		}
	}
}
