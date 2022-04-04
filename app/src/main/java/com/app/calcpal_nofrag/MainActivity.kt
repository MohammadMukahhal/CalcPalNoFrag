package com.app.calcpal_nofrag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import java.lang.Exception

class MainActivity : FragmentActivity() {
    //private lateinit var binding : FragmentButtonsBinding
    //private lateinit var bindingDisplay : FragmentDisplayBinding


    var expression = StringBuilder()
    var operation: Char = ' '
    var leftHandSide: Double = 0.0
    var rightHandSide: Double = 0.0

    //Declaring all widgets
    lateinit var expressionDisplay: TextView
    lateinit var Memory: TextView

    lateinit var button0: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var buttonDEC: Button
    lateinit var buttonDIV: Button
    lateinit var buttonMULT: Button
    lateinit var buttonMOD: Button
    lateinit var buttonPLUS: Button
    lateinit var buttonSUB: Button
    lateinit var buttonNEG: Button
    lateinit var buttonEQUAL: Button
    lateinit var buttonC: Button
    lateinit var buttonCE: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.fragment_buttons)
        //setContentView(R.layout.fragment_display)

         expressionDisplay = findViewById(R.id.expressionDisplay)
         Memory = findViewById(R.id.Memory)

         button0 = findViewById(R.id.button0)
         button1 = findViewById(R.id.button1)
         button2 = findViewById(R.id.button2)
         button3 = findViewById(R.id.button3)
         button4 = findViewById(R.id.button4)
         button5 = findViewById(R.id.button5)
         button6 = findViewById(R.id.button6)
         button7 = findViewById(R.id.button7)
         button8 = findViewById(R.id.button8)
         button9 = findViewById(R.id.button9)
         buttonDEC = findViewById(R.id.buttonDEC)
         buttonMULT = findViewById(R.id.buttonMULT)
         buttonMOD = findViewById(R.id.buttonMOD)
         buttonPLUS = findViewById(R.id.buttonPLUS)
         buttonSUB = findViewById(R.id.buttonSUB)
         buttonDIV = findViewById(R.id.buttonDIV)
         buttonNEG = findViewById(R.id.buttonNEG)
         buttonEQUAL = findViewById(R.id.buttonEQUAL)
         buttonC = findViewById(R.id.buttonC)
         buttonCE = findViewById(R.id.buttonCE)
        //binding = FragmentButtonsBinding.inflate(layoutInflater)
        //bindingDisplay = FragmentDisplayBinding.inflate(layoutInflater)

        expressionDisplay.text = "0"

        start()
    }

    private fun start() {
        button0.setOnClickListener{
            addToExpression("0")
        }
        button1.setOnClickListener{
            addToExpression("1")
        }
        button2.setOnClickListener{
            addToExpression("2")
        }
        button3.setOnClickListener{
            addToExpression("3")
        }
        button4.setOnClickListener{
            addToExpression("4")
        }
        button5.setOnClickListener{
            addToExpression("5")
        }
        button6.setOnClickListener{
            addToExpression("6")
        }
        button7.setOnClickListener{
            addToExpression("7")
        }
        button8.setOnClickListener{
            addToExpression("8")
        }
        button9.setOnClickListener{
            addToExpression("9")
        }
        buttonDEC.setOnClickListener{
            addToExpression(".")
        }
        //Operations

        buttonDIV.setOnClickListener{
            opSelect('/')
        }
        buttonMULT.setOnClickListener{
            opSelect('*')
        }
        buttonMOD.setOnClickListener{
            opSelect('%')
        }
        buttonPLUS.setOnClickListener{
            opSelect('+')
        }
        buttonSUB.setOnClickListener {
            opSelect('-')
        }
        //Other buttons

        buttonNEG.setOnClickListener{
            negative()
        }
        buttonEQUAL.setOnClickListener{
            CalcOp()
        }
        buttonC.setOnClickListener{
            clearAll()
        }
        buttonCE.setOnClickListener{
            clearLast()
        }
    }

    private fun negative() {
        if(expression.length > 0) {
            var num = (expression.toString().toDouble() * -1)
            expression.clear()
            expression.append(num)
            expressionDisplay.text = expression
        }
    }

    private fun clearAll() {
        expression.clear()
        expressionDisplay.text = "0"
        Memory.text = ""
        operation = ' '
        leftHandSide = 0.0
        rightHandSide = 0.0
    }

    private fun clearLast() {
        val length = expression.length
        if(length > 0){
            var str = expression.substring(0,length-1)
            expression.clear()
            expression.append(str)
            if(length-1 != 0) {
                expressionDisplay.text = expression
            }
            else{
                expressionDisplay.text = "0"
            }
        }
    }

    private fun addToExpression(digit:String){
        if(digit != "."){
            expression.append(digit)
            expressionDisplay.text = expression
        }
        else if(digit == "." && expression.indexOf(".") == -1) {
            expression.append(digit)
            expressionDisplay.text = expression
        }
    }

    private fun opSelect(c: Char) {

        operation = c
        leftHandSide = expression.toString().toDouble()
        Memory.text = expression
        expression.clear()
        expressionDisplay.text = operation.toString()
    }

    private fun CalcOp() {

        rightHandSide = expression.toString().toDouble()
        expression.clear()
        var result = 0.0
        when (operation) {

            '+' -> {
                result = (leftHandSide + rightHandSide)
            }
            '-' -> {
                result = (leftHandSide - rightHandSide)
            }
            '*' -> {
                result = (leftHandSide * rightHandSide)
            }
            '/' -> {
                result = (leftHandSide / rightHandSide)
            }
            '%' -> {
                result = (leftHandSide % rightHandSide)
            }
        }
        expressionDisplay.text = result.toString()
        Memory.text = ""
        expression.append(result)
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save c
        super.onSaveInstanceState(outState)
        outState.putString("expressionDisplay", expressionDisplay.text.toString())
        outState.putString("Memory",Memory.text.toString())
        outState.putString("Exp",expression.toString())
        outState.putDouble("left",leftHandSide)
        outState.putDouble("right",rightHandSide)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore
        super.onRestoreInstanceState(savedInstanceState)
        expressionDisplay.text = savedInstanceState.getString("expressionDisplay")
        Memory.text = savedInstanceState.getString("Memory")
        var str = savedInstanceState.getString("Exp")
        expression.append(str)
        leftHandSide = savedInstanceState.getDouble("left")
        rightHandSide = savedInstanceState.getDouble("right")
    }

}