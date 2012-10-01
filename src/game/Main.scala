package game

object Main extends App {
  
  val board = new Board(20,20)
  
  board.setAlive(8, 8)
  board.setAlive(8, 9)
  board.setAlive(8, 10)
  board.setAlive(8, 11)
  board.setAlive(8, 12)
  
  board.setAlive(10, 8)
  board.setAlive(10, 12)
  
  board.setAlive(12, 8)
  board.setAlive(12, 9)
  board.setAlive(12, 10)
  board.setAlive(12, 11)
  board.setAlive(12, 12)
  
  board.printBoard
  
  while(true) {
	  board.evolve
	  board.printBoard
	  Thread.sleep(1000)
  }
}