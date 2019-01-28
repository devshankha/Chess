package com.chess.engine.pieces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;

public class Knight extends Piece {
	private final static int[] CANDIDATE_MOVE_COORDINATES = {-17,-15,-10,-6,6,10,15,17};

	public Knight(int piecePosition, Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);		
	}

	@Override
	public List<Move> calculateLegalMoves(Board board) {
		int candidateDestinationCoordinate;
		final List<Move> legalMoves = new ArrayList<Move>();
		for (final int currentCandidate:CANDIDATE_MOVE_COORDINATES) {
			candidateDestinationCoordinate = this.piecePosition+currentCandidate;
			if (true /* TODO */ ) {
				final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
				if (!candidateDestinationTile.isOccupied()) {
					legalMoves.add(new Move());					
				} else {
					final Piece pieceADestination = candidateDestinationTile.getPiece();
					final Alliance pieceAlliance = pieceADestination.getPieceAlliance();
					if (this.pieceAlliance != pieceAlliance) {
						legalMoves.add(new Move());
					}
				}
				
			}
			
		}
		return Collections.unmodifiableList(legalMoves);
	}
	
	private static boolean isFirstColumnExclusion(final int currentPosition, final int offset) {
		return BoardUtils.FIRST_COLUMN[currentPosition] && ((offset == -17) || (offset == -10));
	}

}
