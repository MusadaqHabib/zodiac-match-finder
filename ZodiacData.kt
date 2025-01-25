package com.example.zodiacmatchfinder.activities

object ZodiacData {
    val relationshipPercentages = mutableMapOf<String, Map<String, Int>>(
        "Aries" to mapOf(
            "Aries" to 100, "Taurus" to 70, "Gemini" to 50,
            "Cancer" to 40, "Leo" to 80, "Virgo" to 60,
            "Libra" to 40, "Scorpio" to 30, "Sagittarius" to 80,
            "Capricorn" to 60, "Aquarius" to 50, "Pisces" to 40
        ),
        "Taurus" to mapOf(
            "Aries" to 70, "Taurus" to 100, "Gemini" to 60,
            "Cancer" to 80, "Leo" to 40, "Virgo" to 70,
            "Libra" to 80, "Scorpio" to 50, "Sagittarius" to 40,
            "Capricorn" to 70, "Aquarius" to 60, "Pisces" to 70
        ),
        "Gemini" to mapOf(
            "Aries" to 50, "Taurus" to 60, "Gemini" to 100,
            "Cancer" to 30, "Leo" to 70, "Virgo" to 40,
            "Libra" to 60, "Scorpio" to 80, "Sagittarius" to 90,
            "Capricorn" to 40, "Aquarius" to 30, "Pisces" to 70
        ),
        "Cancer" to mapOf(
            "Aries" to 40, "Taurus" to 80, "Gemini" to 30,
            "Cancer" to 100, "Leo" to 50, "Virgo" to 60,
            "Libra" to 70, "Scorpio" to 90, "Sagittarius" to 40,
            "Capricorn" to 60, "Aquarius" to 80, "Pisces" to 50
        ),
        "Leo" to mapOf(
            "Aries" to 80, "Taurus" to 40, "Gemini" to 70,
            "Cancer" to 50, "Leo" to 100, "Virgo" to 30,
            "Libra" to 80, "Scorpio" to 60, "Sagittarius" to 50,
            "Capricorn" to 70, "Aquarius" to 40, "Pisces" to 60
        ),
        "Virgo" to mapOf(
            "Aries" to 60, "Taurus" to 70, "Gemini" to 40,
            "Cancer" to 60, "Leo" to 30, "Virgo" to 100,
            "Libra" to 50, "Scorpio" to 70, "Sagittarius" to 60,
            "Capricorn" to 80, "Aquarius" to 90, "Pisces" to 40
        ),
        "Libra" to mapOf(
            "Aries" to 40, "Taurus" to 80, "Gemini" to 60,
            "Cancer" to 70, "Leo" to 80, "Virgo" to 50,
            "Libra" to 100, "Scorpio" to 40, "Sagittarius" to 50,
            "Capricorn" to 40, "Aquarius" to 60, "Pisces" to 70
        ),
        "Scorpio" to mapOf(
            "Aries" to 30, "Taurus" to 50, "Gemini" to 80,
            "Cancer" to 90, "Leo" to 60, "Virgo" to 70,
            "Libra" to 40, "Scorpio" to 100, "Sagittarius" to 70,
            "Capricorn" to 80, "Aquarius" to 50, "Pisces" to 60
        ),
        "Sagittarius" to mapOf(
            "Aries" to 80, "Taurus" to 40, "Gemini" to 90,
            "Cancer" to 40, "Leo" to 50, "Virgo" to 60,
            "Libra" to 50, "Scorpio" to 70, "Sagittarius" to 100,
            "Capricorn" to 30, "Aquarius" to 40, "Pisces" to 80
        ),
        "Capricorn" to mapOf(
            "Aries" to 60, "Taurus" to 70, "Gemini" to 40,
            "Cancer" to 60, "Leo" to 70, "Virgo" to 80,
            "Libra" to 40, "Scorpio" to 80, "Sagittarius" to 30,
            "Capricorn" to 100, "Aquarius" to 50, "Pisces" to 60
        ),
        "Aquarius" to mapOf(
            "Aries" to 50, "Taurus" to 60, "Gemini" to 30,
            "Cancer" to 80, "Leo" to 40, "Virgo" to 90,
            "Libra" to 60, "Scorpio" to 50, "Sagittarius" to 40,
            "Capricorn" to 50, "Aquarius" to 100, "Pisces" to 70
        ),
        "Pisces" to mapOf(
            "Aries" to 40, "Taurus" to 70, "Gemini" to 70,
            "Cancer" to 50, "Leo" to 60, "Virgo" to 40,
            "Libra" to 70, "Scorpio" to 60, "Sagittarius" to 80,
            "Capricorn" to 60, "Aquarius" to 70, "Pisces" to 95
        )
    )


}
