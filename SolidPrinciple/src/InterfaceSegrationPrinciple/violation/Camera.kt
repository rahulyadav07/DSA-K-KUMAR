package InterfaceSegrationPrinciple.violation

// Client should not be force to depend on interface they do not use .
//interface Camera {
//    fun takePhoto()
//    fun recordVedio()
//}
//
//class BasicCamera(): Camera{
//    override fun takePhoto() {
//        print("taking photo")
//    }
//
//    override fun recordVedio() {
//     print("does not support video")
//    }
//
//}

// yaha baisc camera ko unko bhi implemt krna pad rha h jinka kaam hi nhi


interface PhotoCapture {
    fun takePhoto()
}
interface RecordVedio{
    fun recordVideo()
}

open class BasicCamera: PhotoCapture {
    override fun takePhoto() {
        print("taking photo")
    }

}

class DSLRCamera : PhotoCapture, RecordVedio {
    override fun recordVideo() {
        TODO("Not yet implemented")
    }

    override fun takePhoto() {

    }

}