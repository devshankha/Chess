package com.chess.engine.board;

import java.util.HashMap;
import java.util.Map;

import com.chess.engine.pieces.Piece;
import com.google.common.*;
import com.google.common.collect.ImmutableMap;

public abstract class Tile {
	final int tileCoordinates;

	private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

	private Tile(int coordinates) {
		tileCoordinates = coordinates;
	}

	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		for (int i = 0; i < 64; i++) {
			emptyTileMap.put(i, new EmptyTile(i));

		}
		return ImmutableMap.copyOf(emptyTileMap);

	}
	
	public static Tile createTile(final int coordinates, Piece p) {
		return p != null? new OccupiedTile(coordinates, p):EMPTY_TILES_CACHE.get(coordinates);
		
	}

	public abstract boolean isOccupied();

	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {

		private EmptyTile(int coordinates) {
			super(coordinates);

		}

		@Override
		public boolean isOccupied() {

			return false;
		}

		@Override
		public Piece getPiece() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public static final class OccupiedTile extends Tile {

		final Piece piece;

		private OccupiedTile(int coordinates, Piece p) {
			super(coordinates);
			this.piece = p;
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean isOccupied() {
			return true;
		}

		@Override
		public Piece getPiece() {
			return piece;
		}
	}

}
