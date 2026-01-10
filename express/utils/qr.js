import QRCode from "qrcode";
export const generateQRCode = async (text) => {
  try {
    const qrBuffer = await QRCode.toBuffer(text);
    return qrBuffer;
  } catch (error) {
    throw new Error("Failed to generate QR code");
  }
};
