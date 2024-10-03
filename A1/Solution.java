// Java Program for the above approach

import java.util.ArrayList;
import java.util.List;

class Solution {

	private int[][] mover = {{1, 0}, {0, 1}, {-1, 0},
							{0, -1}, {1, 1}, {-1, -1},
							{1, -1}, {-1, 1}};

	public boolean dfs(int x, int y, String word, boolean[][] visited,
						char[][] board) {

		// If word length becomes 0, the string is found
		if (word.length() == 0) {
			return true;
		}

		visited[x][y] = true;
		boolean sol = false;

		// Making possible moves
		for (int[] move : mover) {
			int curr_x = move[0] + x;
			int curr_y = move[1] + y;

			// Checking for out of bound areas
			if (0 <= curr_x && curr_x < board.length && 0 <= curr_y && curr_y < board[0].length) {

				// Checking for similarity in the first letter and the visited array
				if (board[curr_x][curr_y] == word.charAt(0) && !visited[curr_x][curr_y]) {
					String s = word.substring(1);
					sol |= dfs(curr_x, curr_y, s, visited, board);
				}
			}
		}

		visited[x][y] = false;
		return sol;
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> ans = new ArrayList<>();
		boolean[][] visited = new boolean[board.length][board[0].length];

		for (String word : words) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == word.charAt(0)) {
						String s = word.substring(1);
						if (dfs(i, j, s, visited, board)) {
							ans.add(word + " -> {" + i + "," + j + "}");
						}
					}
				}
			}
		}

		return ans;
	}
}

class Main {
	public static void main(String[] args) {
		char[][] board = {{'o', 'a', 'a', 'n'},
						{'e', 't', 'a', 'e'},
						{'i', 'h', 'k', 'r'},
						{'i', 'f', 'l', 'v'}};
		String[] words = {"oath", "pea", "eat", "rain"};
		Solution solver = new Solution();
		List<String> result = solver.findWords(board, words);

		for (String str : result) {
			System.out.println(str);
		}
	}
}

// This code is contributed by Prince Kumar
