package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        //Rola o dado quando abre o app
        rollDice()
    }

    /**
     * Rola o dado e atualiza a tela com o resultado
     */
    private fun rollDice() {
        //Cria um novo dado com 6 lados e rola o dado
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Encontra a ImageView no layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determina qual drawable resource ID será utilizado baseado no dado rolado
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Atualiza a ImageView com o id correto
        diceImage.setImageResource(drawableResource)

        //Atualiza a descrição da imagem com o numero do dado rolado
        diceImage.contentDescription = diceRoll.toString()
    }
}



class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}