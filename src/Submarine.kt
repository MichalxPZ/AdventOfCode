class Submarine {

    private var x = 0
    private var y = 0
    private var z = 0
    private var aim = 0

    fun setAim(value: Int) {
        this.aim = value
    }
    fun getAim(): Int {
        return aim;
    }
    fun changeAim(value: Int) {
        setAim(getAim() + value)
    }
    fun setX(value: Int) {
        this.x = value
    }
    fun setY(value: Int) {
        this.y = value
    }
    fun setZ(value: Int) {
        this.z = value
    }
    fun getX(): Int {
        return x
    }
    fun getY() : Int {
        return y
    }
    fun getZ() : Int {
        return z
    }

    public fun changeX(value: Int) {
        setX(x + value)
    }
    public fun changeY(value: Int) {
        setY(y + value)
    }
    public fun changeZ(value: Int) {
        setZ(z + value)
    }
}