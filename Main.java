
public class Main {

    public static void main(String[] args) {
        MonsterGame game = new MonsterGame();

        while (!game.getIsGameFinished()) {
            game.makeMove();
            game.updateBoard();
            game.drawGameBoard();
            game.cheekAttack();
            game.cheekMonstersAlive();
            game.cheekGameFinished();
        }
        System.out.println("final round: ");
        game.drawGameBoard();
    }
}