package com.storyofluck.storyofluck

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private var numbers: IntArray = intArrayOf(101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206)

    private var brand1: Int = R.drawable.brand1
    private var brand2: Int = R.drawable.brand2
    private var brand3: Int = R.drawable.brand3
    private var brand4: Int = R.drawable.brand4
    private var brand5: Int = R.drawable.brand5
    private var brand6: Int = R.drawable.brand6
    private var brand7: Int = R.drawable.brand1
    private var brand8: Int = R.drawable.brand2
    private var brand9: Int = R.drawable.brand3
    private var brand10: Int = R.drawable.brand4
    private var brand11: Int = R.drawable.brand5
    private var brand12: Int = R.drawable.brand6

    private var playPoints = 0

    private var clickedFirst: Int? = null
    private var clickedSecond: Int? = null

    private var firstCard: Int? = null
    private var secondCard: Int? = null

    private var cardNumber = 1

    private var result=false
    private var isStarted=0
    private var time=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //AppName.fontFeatureSettings(R.assets)
        randomNumbers()
        shuffleNumbers()


        one.setOnClickListener {

            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(one, theCard)


        }
        two.setOnClickListener {

            if (isStarted==0)
                time()
            isStarted=2
            val theCard: Int = (it.tag as String).toInt()
            doStuff(two, theCard)

        }
        three.setOnClickListener {
            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(three, theCard)
        }

        four.setOnClickListener {
            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(four, theCard)
        }

        five.setOnClickListener {
            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(five, theCard)
        }

        six.setOnClickListener {
            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(six, theCard)
        }

        seven.setOnClickListener {
            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(seven, theCard)
        }

        eight.setOnClickListener {
            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(eight, theCard)
        }

        nine.setOnClickListener {
            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(nine, theCard)
        }

        ten.setOnClickListener {
            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(ten, theCard)
        }

        eleven.setOnClickListener {
            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(eleven, theCard)
        }
        twelve.setOnClickListener {
            if (isStarted==0)
                time()
            isStarted=1
            val theCard: Int = (it.tag as String).toInt()
            doStuff(twelve, theCard)
        }
        Stop.setOnClickListener {

           val intent=Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun time(){
        val timer = Timer()
        class UpdateTimeTask : TimerTask() {

            override fun run() {

                if (!result)
                {
                    time++
                    runOnUiThread { Time.text= "TIME: $time s" }
                }
                else
                    runOnUiThread{ Time.text="TIME:"}
            }
        }
        timer.schedule(UpdateTimeTask(), 0, 1000)

    }

    private fun doStuff(iv: ImageView?, theCard: Int) {
        when (numbers[theCard]) {
            101 -> iv?.setImageResource(brand1)
            102 -> iv?.setImageResource(brand2)
            103 -> iv?.setImageResource(brand3)
            104 -> iv?.setImageResource(brand4)
            105 -> iv?.setImageResource(brand5)
            106 -> iv?.setImageResource(brand6)
            201 -> iv?.setImageResource(brand7)
            202 -> iv?.setImageResource(brand8)
            203 -> iv?.setImageResource(brand9)
            204 -> iv?.setImageResource(brand10)
            205 -> iv?.setImageResource(brand11)
            206 -> iv?.setImageResource(brand12)
        }

        if (cardNumber == 1) {
            firstCard = numbers[theCard]
            if (firstCard!! > 200) {
                firstCard = firstCard!! - 100
            }
            cardNumber = 2
            clickedFirst = theCard

            iv?.isEnabled = false

        } else if (cardNumber == 2) {
            secondCard = numbers[theCard]
            if (secondCard!! > 200) {
                secondCard = secondCard!! - 100
            }
            cardNumber = 1
            clickedSecond = theCard

            one.isEnabled = false
            two.isEnabled = false
            three.isEnabled = false
            four.isEnabled = false
            five.isEnabled = false
            six.isEnabled = false
            seven.isEnabled = false
            eight.isEnabled = false
            nine.isEnabled = false
            ten.isEnabled = false
            eleven.isEnabled = false
            twelve.isEnabled = false
            val handler = Handler()
            handler.postDelayed({
                kotlin.run { calculate() }

            }, 1000)
        }
    }

    private fun calculate() {
        if (firstCard == secondCard) {
            when (clickedFirst) {
                0 -> {
                    one.visibility = View.INVISIBLE
                }
                1 -> {
                    two.visibility = View.INVISIBLE
                }
                2 -> {
                    three.visibility = View.INVISIBLE
                }
                3 -> {
                    four.visibility = View.INVISIBLE
                }
                4 -> {
                    five.visibility = View.INVISIBLE
                }
                5 -> {
                    six.visibility = View.INVISIBLE
                }
                6 -> {
                    seven.visibility = View.INVISIBLE
                }
                7 -> {
                    eight.visibility = View.INVISIBLE
                }
                8 -> {
                    nine.visibility = View.INVISIBLE
                }
                9 -> {
                    ten.visibility = View.INVISIBLE
                }
                10 -> {
                    eleven.visibility = View.INVISIBLE
                }
                11 -> {
                    twelve.visibility = View.INVISIBLE
                }
            }
            when (clickedSecond) {
                0 -> {
                    one.visibility = View.INVISIBLE
                }
                1 -> {
                    two.visibility = View.INVISIBLE
                }
                2 -> {
                    three.visibility = View.INVISIBLE
                }
                3 -> {
                    four.visibility = View.INVISIBLE
                }
                4 -> {
                    five.visibility = View.INVISIBLE
                }
                5 -> {
                    six.visibility = View.INVISIBLE
                }
                6 -> {
                    seven.visibility = View.INVISIBLE
                }
                7 -> {
                    eight.visibility = View.INVISIBLE
                }
                8 -> {
                    nine.visibility = View.INVISIBLE
                }
                9 -> {
                    ten.visibility = View.INVISIBLE
                }
                10 -> {
                    eleven.visibility = View.INVISIBLE
                }
                11 -> {
                    twelve.visibility = View.INVISIBLE
                }
            }

            playPoints++
            score.text = "SCORES: $playPoints"
        } else {
            one.setImageResource(R.drawable.clever)
            two.setImageResource(R.drawable.clever)
            three.setImageResource(R.drawable.clever)
            four.setImageResource(R.drawable.clever)
            five.setImageResource(R.drawable.clever)
            six.setImageResource(R.drawable.clever)
            seven.setImageResource(R.drawable.clever)
            eight.setImageResource(R.drawable.clever)
            nine.setImageResource(R.drawable.clever)
            ten.setImageResource(R.drawable.clever)
            eleven.setImageResource(R.drawable.clever)
            twelve.setImageResource(R.drawable.clever)
        }
        one.isEnabled = true
        two.isEnabled = true
        three.isEnabled = true
        four.isEnabled = true
        five.isEnabled = true
        six.isEnabled = true
        seven.isEnabled = true
        eight.isEnabled = true
        nine.isEnabled = true
        ten.isEnabled = true
        eleven.isEnabled = true
        twelve.isEnabled = true

        isEnd()

    }

    private fun isEnd() {
        if (one.visibility == View.INVISIBLE &&
                two.visibility == View.INVISIBLE &&
                three.visibility == View.INVISIBLE &&
                four.visibility == View.INVISIBLE &&
                five.visibility == View.INVISIBLE &&
                six.visibility == View.INVISIBLE &&
                seven.visibility == View.INVISIBLE &&
                eight.visibility == View.INVISIBLE &&
                nine.visibility == View.INVISIBLE &&
                ten.visibility == View.INVISIBLE &&
                eleven.visibility == View.INVISIBLE &&
                twelve.visibility == View.INVISIBLE) {
            result=true
            val alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.apply {
                setMessage("Game Over! " +
                        "Score:$playPoints " +
                        "Time: $time  " +
                        "Click STOP for a new game!")
            }
            val alertDialogB = alertDialog.create()
            alertDialogB.show()
        }
    }

    private fun shuffleNumbers() {
        numbers.shuffle()

    }


    private fun randomNumbers() {
        one.tag = "0"
        two.tag = "1"
        three.tag = "2"
        four.tag = "3"
        five.tag = "4"
        six.tag = "5"
        seven.tag = "6"
        eight.tag = "7"
        nine.tag = "8"
        ten.tag = "9"
        eleven.tag = "10"
        twelve.tag = "11"
    }


}

