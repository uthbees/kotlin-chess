// I can't get the actual assert function to work, so here's my own implementation.
// (I just copy-pasted from the actual implementation.)

fun assert(value: Boolean) {
    if (!value) {
        throw AssertionError("Assertion failed")
    }
}

fun assert(value: Boolean, message: String) {
    if (!value) {
        throw AssertionError(message)
    }
}
