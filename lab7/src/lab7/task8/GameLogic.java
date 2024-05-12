package lab7.task8;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameLogic extends DiceGame {
    public static void run() {
        dice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int moveCount = dice.getValue();
                Player player = players[playerToMove];
                cells[player.getPosition()].removePlayer(player);
                player.move(moveCount);
                int position = player.getPosition();
                cells[position].addPlayer(player);
                if (cells[position].getCellState() == null) {
                    player.setScore(player.getScore() + cells[position].getPoints());
                }
                else {
                    switch (cells[position].getCellState()) {
                        case REPEAT -> {
                            // Выход на следующую итерацию
                        }
                        case LOSTALL -> {
                            if (player.getScore() > 0) {
                                player.setScore(0);
                            }
                        }
                        case FINISH -> {
                            player.setFinished(true);
                        }
                    }
                }
                DiceGame.cellCore.updateFields();
                if (!setNextPlayer()) {
                    System.out.println("Game over");
                    System.out.println("Победил игрок " + (getWinner() + 1));
                    System.exit(0);
                }
            }
        });
    }
    private static int getWinner() {
        int winnerIndex = 0;
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getScore() > maxScore) {
                maxScore = players[i].getScore();
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }
    private static boolean setNextPlayer() {
        setNextIndex();
        boolean flag = false;
        for (int i = 0; i < players.length; i++) {
            if (players[playerToMove].isFinished()) {
                setNextIndex();
                continue;
            }
            flag = true;
            break;
        }
        return flag;
    }
    private static void setNextIndex() {
        if (playerToMove + 1 == players.length) {
            playerToMove = 0;
        }
        else playerToMove++;
    }
}