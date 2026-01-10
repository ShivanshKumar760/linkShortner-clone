let toEntity = (dto, shortCode, qr) => ({
  originalUrl: dto.originalUrl,
  shortCode,
  qrCode: qr,
});

let toResponse = (entity, baseUrl) => ({
  originalUrl: entity.originalUrl,
  shortUrl: baseUrl + entity.shortCode,
  qrCodeBase64: entity.qrCode.toString("base64"),
});

export { toEntity, toResponse };
