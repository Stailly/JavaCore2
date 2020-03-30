package hw1.contestant;

abstract class TypedContestant extends Contestant {
    public TypedContestant(String type, String name, int runLength, int jumpHeight) {
        super(type + " " + name, runLength, jumpHeight);
    }
}
