package mail

interface Mailer {
    fun sendMessage(email: String, message: String)
}

class PersonalInfo(val email: String?)
class Client(val personalInfo: PersonalInfo?)

fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {

    if (client?.personalInfo?.email != null && message != null) {
        mailer.sendMessage(client.personalInfo.email, message)
    }
}