package rstefanyshyn.messaging.domain.message.vo;

public record MessageMediaContent(byte[] file,
                                  String mimetype) {
}