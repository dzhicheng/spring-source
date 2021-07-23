package com.dongzhic.design.pattern.builder;

/**
 * 建造者模式
 */
public class BuilderClass {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    /**
     * 匿名内部类解决单例问题
     */
    public static class Builder {
        // 必要参数
        private final int servingSize;
        private final int servings;

        // 可选参数
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            this.calories = val;
            return this;
        }

        public Builder fat(int val) {
            this.fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            this.carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }

        public BuilderClass build() {
            return new BuilderClass(this);
        }
    }

    private BuilderClass(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        BuilderClass cocaCola = new Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
    }
}
