package com.example.recycler;

public class DataObjects {

    public class Book implements Literature {

        @Override
        public int getType() {
            return Literature.TYPE_BOOK;
        }
    }

    public class Magazine implements Literature {

        @Override
        public int getType() {
            return Literature.TYPE_MAGAZINE;
        }
    }

    public class Newspaper implements Literature {

        @Override
        public int getType() {
            return Literature.TYPE_NEWSPAPER;
        }
    }

}
