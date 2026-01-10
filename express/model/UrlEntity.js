import mongoose from "mongoose";

const urlSchema = new mongoose.Schema({
  originalUrl: { type: String, required: true },
  shortCode: { type: String, required: true, unique: true },
  qrCode: Buffer,
});

const UrlEntity = mongoose.model("UrlEntity", urlSchema);

export { UrlEntity };
