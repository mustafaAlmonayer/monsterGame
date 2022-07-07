import java.util.ArrayList;
import java.util.Arrays;

public class MonsterGame {

    private char[][] gameBoard;
    private final ArrayList<Monster> monsters;
    private final String[] NAMES;
    private boolean isGameFinished;

    public MonsterGame(){
        this.gameBoard = this.makeGameBoard();
        this.NAMES = new String[]{"Frank", "Gorge", "Jeo", "Hank"};
        this.monsters = this.generateMonsters();
    }

    public char[][] makeGameBoard() {
        char[][] gameBoard = new char[10][10];

        for (char[] row : gameBoard){
            Arrays.fill(row, '*');
        }

        return gameBoard;
    }

    public ArrayList<Monster> generateMonsters() {
        ArrayList<Monster> genMonsters = new ArrayList<>(4);

        for(int i = 0; i < 4 ; i++) {
            genMonsters.add(new Monster(this.NAMES[i]));
        }
        return genMonsters;
    }

    public void makeMove() {
        for (Monster monster: this.monsters) {
            int[] pos = genMove();
            monster.setYPos(pos[1]);
            monster.setXPos(pos[0]);
        }
    }

    public int[] genMove() {
        int x = (int)(Math.random() * 10) ;
        int y = (int)(Math.random() * 10) ;

        if (isEmpty(x, y)){
            return new int[]{x, y};
        } else {
            return genMove();
        }

    }

    public void updateBoard() {
        this.gameBoard = this.makeGameBoard();
        for(Monster monster: this.monsters){
            this.gameBoard[monster.getYPos()][monster.getXPos()] = monster.getCODE();
        }
    }

    public void drawGameBoard(){
        for (Monster monster: this.monsters) {
            System.out.println(monster.toString());
        }
        for(char[] row : this.gameBoard) {
            for (char column : row) {
                System.out.print("|" + column + "|");
            }
            System.out.println();
        }
    }

    public void cheekAttack(){
        for (int i = 0; i < this.monsters.size(); i++) {
            for (int j = 0; j < this.monsters.size();j++) {
                if (!(i==j)){

                    // cheek if the monster can make an attack to any monster that is 1 block away from it on x and y axis
                    ArrayList<Integer> border = new ArrayList<>();
                    border.add(1);
                    border.add(-1);
                    border.add(0);
                    if (border.contains(this.monsters.get(i).getYPos() - this.monsters.get(j).getYPos()) &&
                            border.contains(this.monsters.get(i).getXPos() - this.monsters.get(j).getXPos())){
                        this.makeAttack(monsters.get(i), monsters.get(j));
                    }

                }
            }
        }
    }

    public void makeAttack(Monster attacker, Monster attacked){
        attacked.setHealth(attacked.getHealth() - attacker.getDMG());
    }


    public boolean isEmpty(int x, int y) {
        return this.gameBoard[x][y] == '*';
    }



    public void cheekMonstersAlive() {
        ArrayList<Monster> delMonsters = new ArrayList<>();

        for (int i = 0; i < this.monsters.size() ; i++) {
            if (!this.monsters.get(i).getAlive()){
                this.gameBoard[this.monsters.get(i).getYPos()][this.monsters.get(i).getXPos()] = '*';
                delMonsters.add(this.monsters.get(i));

            }
        }
        this.monsters.removeAll(delMonsters);
    }

    public void cheekGameFinished(){
        if (this.monsters.size() == 1 || this.monsters.size() == 0){
            this.isGameFinished = true;
        }
    }
    public boolean getIsGameFinished(){
        return this.isGameFinished;
    }
}
