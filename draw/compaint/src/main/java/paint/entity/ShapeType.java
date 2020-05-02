package paint.entity;

public enum  ShapeType {
    /**
     *
     */
    Cercle(0),

    Rectangle(1),

    DesCarre(2),

    Triangle(3);

    private int code;

    ShapeType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ShapeType getByCode(int code){
        for(ShapeType type : ShapeType.values()){
            if(type.getCode() == code){
                return type;
            }
        }
        return Cercle;
    }
}
