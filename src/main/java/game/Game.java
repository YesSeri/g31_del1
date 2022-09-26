package game;

public class Game {
    private Player player_1;
    private Player player_2;
    private boolean player_1_turn = true;
    private int current_turn = 1;

    public Game() {
        this.player_1 = new Player();
        this.player_2 = new Player();
    }


    // add value of two dices to the player whose turn it is.
    private void play_round() {
        Dice dice_1 = new Dice();
        Dice dice_2 = new Dice();
        int dice_value_1 = dice_1.throw_dice();
        int dice_value_2 = dice_2.throw_dice();
        int sum = dice_value_1 + dice_value_2;
        if (player_1_turn) {
            player_1.addPoints(sum);
        } else {
            player_2.addPoints(sum);
        }
        player_1_turn = !player_1_turn;
    }

    public void play_game() {
        while (player_1.getPoints() < 40 && player_2.getPoints() < 40) {
            play_round();
            current_turn++;
            System.out.println("Turn " + current_turn + ":\nPlayer 1: " + player_1.getPoints() + "\nPlayer 2: " + player_2.getPoints());
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game);
        game.play_game();
    }
}
