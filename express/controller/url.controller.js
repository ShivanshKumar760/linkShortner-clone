import * as service from "../service/url.service.js";

export let shorten = async (req, res) => {
  const result = await service.createShortUrl(req.body);
  res.json(result);
};

export let redirect = async (req, res) => {
  const url = await service.getOriginal(req.params.code);
  res.redirect(url);
};

export let downloadQr = async (req, res) => {
  const qr = await service.getQr(req.params.code);
  res.set("Content-Type", "image/png");
  res.send(qr);
};
