package TowerDefense;

public final class Config
{
        /**
         * Game name. Change it if you want.
         */
        public static final String GAME_NAME = "The Game";



        public static final int TILE_SIZE = 64;
        /**
         * Num of tiles the screen can display if fieldZoom is TILE_SIZE,
         * in other words, the texture will be display as it without scaling.
         */
        public static final int TILE_HORIZONTAL = 24;
        public static final int TILE_GAMEFIELD = 19;
        /**
         * Num of tiles the screen can display if fieldZoom is TILE_SIZE,
         * in other words, the texture will be display as it without scaling.
         */
        public static final int TILE_VERTICAL = 12;
        /**
         * An arbitrary number just to make some code run a little faster.
         * Do not touch.
         */
        public static final int _TILE_MAP_COUNT = (int) (TILE_HORIZONTAL * TILE_VERTICAL);


        /**
         * Size of the screen.
         */
        public static final int SCREEN_WIDTH = TILE_SIZE * TILE_HORIZONTAL;

        public static final int GAMEFIELD_WIDTH = TILE_SIZE * TILE_GAMEFIELD;

        /**
         * Size of the screen.
         */
        public static final int SCREEN_HEIGHT = TILE_SIZE * TILE_VERTICAL;


        //Other config related to other entities in the game.



}


