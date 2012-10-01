package game

import Array._

class Board(private val lines:Int, private val columns:Int) {
	private var board = ofDim[Int](lines, columns)
	
	def setAlive(line:Int, column:Int) {
	  board(line)(column) = 1
	}
	
	private def countNeighbours(line:Int, column:Int) : Int = {
	  var sum = 0;
	  for(i <- Math.max(0, line-1) to Math.min(lines-1, line+1))
	    for(j <- Math.max(0, column-1) to Math.min(columns-1, column+1))
	      sum += board(i)(j)
	  return sum-board(line)(column)
	}
	
	def evolve() {
	  var new_board = ofDim[Int](lines, columns)
	  
	  for(i <- 0 to lines-1)
	    for(j <- 0 to columns-1) {
	      val neighbours = countNeighbours(i, j)
	      if(board(i)(j) == 1) {
	    	  if(neighbours < 2 || neighbours > 3)
	    	    new_board(i)(j) = 0
	    	  else
	    	    new_board(i)(j) = 1
	      }
	      else if(neighbours == 3)
	        new_board(i)(j) = 1
	    }
	  
	  board = new_board
	}
	
	def printBoard() {
	  for(i <- 0 to lines-1) {
	    for(j <- 0 to columns-1)
	      if(board(i)(j) == 1)
	    	  print("X")
	      else
	    	  print("_")
	    println() 
	  }
	  println()
	}
}

