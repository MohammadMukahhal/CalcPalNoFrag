package com.app.calcpal_nofrag;

public class Holder {
    /*
        private lateinit var binding : ActivityMainBinding
    private var expression = ""
    //Create a number Array
    private var op = ' '
    private var opChange = false
    private var memory = 0.0
    private var oldNum = 0.0
    private var result = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        start()
    }

    fun addDigit(item:Char){
        expression += item
        getOut()
    }

    fun clearLast(){
        try {
            expression = expression[(expression.length - 1)].toString()
            getOut()
        }
        catch (e: Exception){

        }
    }

    fun clearAll(){
        expression = ""
        memory = 0.0
        oldNum = 0.0
        opChange = false
        getOut()
    }

    fun makeNegative(){
        var num = expression.toString()
        num = (num.toDouble() * -1).toString()
        replaceAll(num)
        getOut()
    }

    fun equal(): String {
        var finalNumber = 0.0
        if(expression.length != 0 && opChange){
            when(op){
                '*'->
                {
                    finalNumber = oldNum * expression.toDouble()
                }
                '/'->
                {
                    finalNumber = oldNum * expression.toDouble()
                }
                '-'->
                {
                    finalNumber = oldNum * expression.toDouble()
                }
                '+'->
                {
                    finalNumber = oldNum * expression.toDouble()
                }
                '%'->
                {
                    finalNumber = oldNum * expression.toDouble()
                }
            }
            opChange = false
        }
        memory = finalNumber
        return finalNumber.toString()

    }

    fun start() {
        binding.button0.setOnClickListener{
            addDigit('0')
        }
        binding.button1.setOnClickListener{
            addDigit('1')
        }
        binding.button2.setOnClickListener{
            addDigit('2')
        }
        binding.button3.setOnClickListener{
            addDigit('3')
        }
        binding.button4.setOnClickListener{
            addDigit('4')
        }
        binding.button5.setOnClickListener{
            addDigit('5')
        }
        binding.button6.setOnClickListener{
            addDigit('6')
        }
        binding.button7.setOnClickListener{
            addDigit('7')
        }
        binding.button8.setOnClickListener{
            addDigit('8')
        }
        binding.button9.setOnClickListener{
            addDigit('9')
        }
        binding.buttonC.setOnClickListener{
            clearAll()
        }
        binding.buttonCE.setOnClickListener{
            clearLast()
        }
        binding.buttonDIV.setOnClickListener{
            opEvent('/')
        }
        binding.buttonDEC.setOnClickListener{
            addDigit('.')
        }
        binding.buttonMULT.setOnClickListener{
            opEvent('*')
        }
        binding.buttonMOD.setOnClickListener{
            opEvent('%')
        }
        binding.buttonEQUAL.setOnClickListener{
            result = equal()
            getOut()
        }
        binding.buttonPLUS.setOnClickListener{
            opEvent('+')
        }
        binding.buttonNEG.setOnClickListener{
            makeNegative()
        }
        binding.buttonSUB.setOnClickListener {
            opEvent('-')
        }
    }

    private fun replaceAll(num:String){
        expression = ""

        for (i in 0..num.length){
            expression += num[i]
        }
    }

    private fun opEvent(item:Char){
        op = item
        opChange = true
        if(expression.length == 0){
            expression += '0'
        }
        oldNum = expression.toDouble()
    }



    fun getOut(){
        var exp = ""

        if(oldNum != 0.0){
            exp += " " + expression
            if(result != ""){
                exp = result
            }
        }
        else if(opChange){
            exp += op.toString()
            opChange = false
        }
        else{
            exp = expression
        }

        binding.expressionDisplay.text =  exp
    }
     */
}
