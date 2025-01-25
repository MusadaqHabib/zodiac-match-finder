package com.example.zodiacmatchfinder.activities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "zodiac_match"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "compatibilitY"
        private const val COL_NAME_AS_ID = "NameAsID"
        private const val COL_SCORPIO = "Scorpio"
        private const val COL_CANCER = "Cancer"
        private const val COL_TAURUS = "Taurus"
        private const val COL_CAPRICORN = "Capricorn"
        private const val COL_PISCES = "Pisces"
        private const val COL_LEO = "Leo"
        private const val COL_SAGITTARIUS = "Sagittarius"
        private const val COL_VIRGO = "Virgo"
        private const val COL_ARIES = "Aries"
        private const val COL_AQUARIUS = "Aquarius"
        private const val COL_GEMINI = "Gemini"
        private const val COL_LIBRA = "Libra"

    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COL_NAME_AS_ID TEXT PRIMARY KEY," +
                "$COL_SCORPIO INTEGER," +
                "$COL_CANCER INTEGER," +
                "$COL_TAURUS INTEGER," +
                "$COL_CAPRICORN INTEGER," +
                "$COL_PISCES INTEGER," +
                "$COL_LEO INTEGER," +
                "$COL_SAGITTARIUS INTEGER," +
                "$COL_VIRGO INTEGER," +
                "$COL_ARIES INTEGER," +
                "$COL_AQUARIUS INTEGER," +
                "$COL_GEMINI INTEGER," +
                "$COL_LIBRA INTEGER)"

        db.execSQL(createTableQuery)
        insertCompatibility(db, "Scorpio", 80, 85, 60, 95, 75, 85, 85, 90, 80, 65, 60, 95)
        insertCompatibility(db, "Cancer", 65, 80, 60, 75, 70, 75, 60, 95, 55, 45, 70, 90)
        insertCompatibility(db, "Taurus", 60, 70, 70, 80, 70, 90, 75, 85, 50, 95, 80, 85)
        insertCompatibility(db, "Capricorn",50, 95, 50, 45, 45, 95, 85, 65, 55, 85, 70, 80)
        insertCompatibility(db, "Pisces", 65, 85, 50, 90, 75, 70, 50, 95, 75, 85, 55, 80)
        insertCompatibility(db, "Leo", 90, 70, 80, 70, 85, 75, 65, 75, 95, 45, 70, 75 )
        insertCompatibility(db, "Sagittarius", 90, 50, 75, 55, 95, 70, 80, 85, 85, 55, 60, 75 )
        insertCompatibility(db, "Virgo", 45, 90, 75, 75, 75, 70, 80, 85, 70, 95, 50, 70 )
        insertCompatibility(db, "Aries", 60, 65, 65, 65, 90, 45, 70, 80, 90, 50, 55, 65 )
        insertCompatibility(db, "Aquarius", 55, 80, 90, 70, 70, 50, 95, 60, 60, 70, 80, 55)
        insertCompatibility(db, "Gemini", 70, 70, 75, 60, 80, 75, 90, 60, 75, 50, 90, 50)
        insertCompatibility(db, "Libra", 70, 75, 90, 60, 65, 80, 80, 85, 80, 85, 95, 50)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    fun getCompatibilityValue(sign1: String, sign2: String): Int {
        val db = readableDatabase
        var compatibilityValue = -1

        val query = "SELECT ${getColumnName(sign1)} FROM $TABLE_NAME WHERE $COL_NAME_AS_ID = ?"
        val cursor = db.rawQuery(query, arrayOf(sign2))

        if (cursor.moveToFirst()) {
            compatibilityValue = cursor.getInt(0)
        }

        cursor.close()
        db.close()

        return compatibilityValue
    }
    private fun insertCompatibility(db: SQLiteDatabase, nameAsId: String, scorpio: Int, cancer: Int, taurus: Int,
                                    capricorn: Int, pisces: Int, leo: Int, sagittarius: Int, virgo: Int,
                                    aries: Int, aquarius: Int, gemini: Int, libra: Int) {
        val values = ContentValues()
        values.put(COL_NAME_AS_ID, nameAsId)
        values.put(COL_SCORPIO, scorpio)
        values.put(COL_CANCER, cancer)
        values.put(COL_TAURUS, taurus)
        values.put(COL_CAPRICORN, capricorn)
        values.put(COL_PISCES, pisces)
        values.put(COL_LEO, leo)
        values.put(COL_SAGITTARIUS, sagittarius)
        values.put(COL_VIRGO, virgo)
        values.put(COL_ARIES, aries)
        values.put(COL_AQUARIUS, aquarius)
        values.put(COL_GEMINI, gemini)
        values.put(COL_LIBRA, libra)

        db.insert(TABLE_NAME, null, values)
    }
    private fun getColumnName(sign: String): String {
        return when (sign) {
            "Scorpio" -> COL_SCORPIO
            "Cancer" -> COL_CANCER
            "Taurus" -> COL_TAURUS
            "Capricorn" -> COL_CAPRICORN
            "Pisces" -> COL_PISCES
            "Leo" -> COL_LEO
            "Sagittarius" -> COL_SAGITTARIUS
            "Virgo" -> COL_VIRGO
            "Aries" -> COL_ARIES
            "Aquarius" -> COL_AQUARIUS
            "Gemini" -> COL_GEMINI
            "Libra" -> COL_LIBRA
            else -> ""
        }
    }

}