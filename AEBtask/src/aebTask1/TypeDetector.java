package aebTask1;
//Класс с условиями отбора номеров

public  class TypeDetector {
        public boolean is121212type(char[] chars) {
                return chars[0] == chars[2] &&
                        chars[2] == chars[4] &&
                        chars[1] == chars[3] &&
                        chars[3] == chars[5];
        }

        public boolean is123123type(char[] chars) {
                return chars[0] == chars[3] &&
                        chars[1] == chars[4] &&
                        chars[2] == chars[5];
        }

        public boolean is123456type(char[] chars) {
                int check = 0;
                for (int i = 0; i < chars.length - 1 ;  i++) {
                        if (chars[i + 1] - chars[i] == 1) {
                                check++;
                        }
                }
                return check == 5;
        }

        public boolean is111222type(char[] chars) {
                return chars[0] == chars[1] &&
                        chars[0] == chars[2] &&
                        chars[3] == chars[4] &&
                        chars[3] == chars[5];
        }

        public boolean is123321type(char[] chars) {
                return chars[0] == chars[5] &&
                        chars[1] == chars[4] &&
                        chars[2] == chars[3];
        }

        public boolean is112233type(char[] chars) {
                return chars[0] == chars[1] &&
                        chars[2] == chars[3] &&
                        chars[4] == chars[5];
        }
}
