package com.snake.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.snake.controller.Controller;
import com.snake.entities.Food;
import com.snake.entities.Ground;
import com.snake.entities.Snake;
import com.snake.util.Global;
import com.snake.view.GamePanel;


public class Game {


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Snake snake = new Snake();
        Food food = new Food();
        Ground ground = new Ground();

        GamePanel gamePanel = new GamePanel();
        Controller controller = new Controller(snake, food, ground, gamePanel);
        JPanel panel = new JPanel();
        panel.setSize(Global.WIDTH * Global.CELL_SIZE + 15,
                80);
        JButton button1 = new JButton("ÔÝÍ£");
        panel.setBackground(Color.white);
        panel.add(button1);
        panel.setLayout(null);
        button1.setBounds(150, 575, 80, 30);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel.setSize(Global.WIDTH * Global.CELL_SIZE,
                Global.HEIGHT * Global.CELL_SIZE);
//		gamePanel.add(button1);
        JLabel label1 = new JLabel();
        label1.setText(String.valueOf(snake.win));
//		gamePanel.add(label1);
        frame.setSize(Global.WIDTH * Global.CELL_SIZE + 15,
                Global.HEIGHT * Global.CELL_SIZE + 35);
//		frame.add(panel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);
        gamePanel.addKeyListener(controller);
//		panel.addKeyListener(controller);
        snake.addSnakeListener(controller);

        frame.addKeyListener(controller);
        frame.setVisible(true);
        controller.newGame();
    }
}
