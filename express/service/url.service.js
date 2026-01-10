import { UrlEntity } from "../model/UrlEntity.js";
import { v4 as uuid } from "uuid";
import { generateQRCode } from "../utils/qr.js";
import { toEntity, toResponse } from "../mapper/url.mapper.js";

const BASE_URL = "http://localhost:8080/";

export const createShortUrl = async (urlDto) => {
  //Genrate a unique short code
  const shortCode = uuid().slice(0, 8);
  //genrate a short url
  const shortUrl = BASE_URL + shortCode;
  //Generate QR code for the short url
  const qrImage = await generateQRCode(shortUrl);
  const urlEntity = toEntity(urlDto, shortCode, qrImage);
  const savedEntity = await UrlEntity.create(urlEntity);
  return toResponse(savedEntity, BASE_URL);
};

export const getOriginal = async (code) => {
  const url = await UrlEntity.findOne({ shortCode: code });
  if (!url) throw new Error("Not found");
  return url.originalUrl;
};

export const getQr = async (code) => {
  const url = await UrlEntity.findOne({ shortCode: code });
  if (!url) throw new Error("Not found");
  return url.qrCode;
};
