var hexcase = 1;   
var b64pad  = "";   
var chrsz   = 8;   
function hex_md5(s){ return binl2hex(core_md5(str2binl(s), s.length * chrsz));}   
function b64_md5(s){ return binl2b64(core_md5(str2binl(s), s.length * chrsz));}   
function str_md5(s){ return binl2str(core_md5(str2binl(s), s.length * chrsz));}   
function hex_hmac_md5(key, data) { return binl2hex(core_hmac_md5(key, data)); }   
function b64_hmac_md5(key, data) { return binl2b64(core_hmac_md5(key, data)); }   
function str_hmac_md5(key, data) { return binl2str(core_hmac_md5(key, data)); }   

function core_md5(x, len)   
{   
  x[len >> 5] |= 0x80 << ((len) % 32);   
  x[(((len + 64) >>> 9) << 4) + 14] = len;   
 
  var a =  1732584193;   
  var b = -271733879;   
  var c = -1732584194;   
  var d =  271733878;   
 
  for(var i = 0; i < x.length; i += 16)   
  {   
    var olda = a;   
    var oldb = b;   
    var oldc = c;   
    var oldd = d;   
 
    a = md5_ff(a, b, c, d, x[i+ 0], 7 , -680876936);   
    d = md5_ff(d, a, b, c, x[i+ 1], 12, -389564586);   
    c = md5_ff(c, d, a, b, x[i+ 2], 17,  606105819);   
    b = md5_ff(b, c, d, a, x[i+ 3], 22, -1044525330);   
    a = md5_ff(a, b, c, d, x[i+ 4], 7 , -176418897);   
    d = md5_ff(d, a, b, c, x[i+ 5], 12,  1200080426);   
    c = md5_ff(c, d, a, b, x[i+ 6], 17, -1473231341);   
    b = md5_ff(b, c, d, a, x[i+ 7], 22, -45705983);   
    a = md5_ff(a, b, c, d, x[i+ 8], 7 ,  1770035416);   
    d = md5_ff(d, a, b, c, x[i+ 9], 12, -1958414417);   
    c = md5_ff(c, d, a, b, x[i+10], 17, -42063);   
    b = md5_ff(b, c, d, a, x[i+11], 22, -1990404162);   
    a = md5_ff(a, b, c, d, x[i+12], 7 ,  1804603682);   
    d = md5_ff(d, a, b, c, x[i+13], 12, -40341101);   
    c = md5_ff(c, d, a, b, x[i+14], 17, -1502002290);   
    b = md5_ff(b, c, d, a, x[i+15], 22,  1236535329);   
 
    a = md5_gg(a, b, c, d, x[i+ 1], 5 , -165796510);   
    d = md5_gg(d, a, b, c, x[i+ 6], 9 , -1069501632);   
    c = md5_gg(c, d, a, b, x[i+11], 14,  643717713);   
    b = md5_gg(b, c, d, a, x[i+ 0], 20, -373897302);   
    a = md5_gg(a, b, c, d, x[i+ 5], 5 , -701558691);   
    d = md5_gg(d, a, b, c, x[i+10], 9 ,  38016083);   
    c = md5_gg(c, d, a, b, x[i+15], 14, -660478335);   
    b = md5_gg(b, c, d, a, x[i+ 4], 20, -405537848);   
    a = md5_gg(a, b, c, d, x[i+ 9], 5 ,  568446438);   
    d = md5_gg(d, a, b, c, x[i+14], 9 , -1019803690);   
    c = md5_gg(c, d, a, b, x[i+ 3], 14, -187363961);   
    b = md5_gg(b, c, d, a, x[i+ 8], 20,  1163531501);   
    a = md5_gg(a, b, c, d, x[i+13], 5 , -1444681467);   
    d = md5_gg(d, a, b, c, x[i+ 2], 9 , -51403784);   
    c = md5_gg(c, d, a, b, x[i+ 7], 14,  1735328473);   
    b = md5_gg(b, c, d, a, x[i+12], 20, -1926607734);   
 
 
    a = md5_hh(a, b, c, d, x[i+ 5], 4 , -378558);   
    d = md5_hh(d, a, b, c, x[i+ 8], 11, -2022574463);   
    c = md5_hh(c, d, a, b, x[i+11], 16,  1839030562);   
    b = md5_hh(b, c, d, a, x[i+14], 23, -35309556);   
    a = md5_hh(a, b, c, d, x[i+ 1], 4 , -1530992060);   
    d = md5_hh(d, a, b, c, x[i+ 4], 11,  1272893353);   
    c = md5_hh(c, d, a, b, x[i+ 7], 16, -155497632);   
    b = md5_hh(b, c, d, a, x[i+10], 23, -1094730640);   
    a = md5_hh(a, b, c, d, x[i+13], 4 ,  681279174);   
    d = md5_hh(d, a, b, c, x[i+ 0], 11, -358537222);   
    c = md5_hh(c, d, a, b, x[i+ 3], 16, -722521979);   
    b = md5_hh(b, c, d, a, x[i+ 6], 23,  76029189);   
    a = md5_hh(a, b, c, d, x[i+ 9], 4 , -640364487);   
    d = md5_hh(d, a, b, c, x[i+12], 11, -421815835);   
    c = md5_hh(c, d, a, b, x[i+15], 16,  530742520);   
    b = md5_hh(b, c, d, a, x[i+ 2], 23, -995338651);   
 
    a = md5_ii(a, b, c, d, x[i+ 0], 6 , -198630844);   
    d = md5_ii(d, a, b, c, x[i+ 7], 10,  1126891415);   
    c = md5_ii(c, d, a, b, x[i+14], 15, -1416354905);   
    b = md5_ii(b, c, d, a, x[i+ 5], 21, -57434055);   
    a = md5_ii(a, b, c, d, x[i+12], 6 ,  1700485571);   
    d = md5_ii(d, a, b, c, x[i+ 3], 10, -1894986606);   
    c = md5_ii(c, d, a, b, x[i+10], 15, -1051523);   
    b = md5_ii(b, c, d, a, x[i+ 1], 21, -2054922799);   
    a = md5_ii(a, b, c, d, x[i+ 8], 6 ,  1873313359);   
    d = md5_ii(d, a, b, c, x[i+15], 10, -30611744);   
    c = md5_ii(c, d, a, b, x[i+ 6], 15, -1560198380);   
    b = md5_ii(b, c, d, a, x[i+13], 21,  1309151649);   
    a = md5_ii(a, b, c, d, x[i+ 4], 6 , -145523070);   
    d = md5_ii(d, a, b, c, x[i+11], 10, -1120210379);   
    c = md5_ii(c, d, a, b, x[i+ 2], 15,  718787259);   
    b = md5_ii(b, c, d, a, x[i+ 9], 21, -343485551);   
 
    a = safe_add(a, olda);   
    b = safe_add(b, oldb);   
    c = safe_add(c, oldc);   
    d = safe_add(d, oldd);   
  }   
  return Array(a, b, c, d);   
}   
function md5_cmn(q, a, b, x, s, t)   
{   
  return safe_add(bit_rol(safe_add(safe_add(a, q), safe_add(x, t)), s),b);   
}   
function md5_ff(a, b, c, d, x, s, t)   
{   
  return md5_cmn((b & c) | ((~b) & d), a, b, x, s, t);   
}   
function md5_gg(a, b, c, d, x, s, t)   
{   
  return md5_cmn((b & d) | (c & (~d)), a, b, x, s, t);   
}   
function md5_hh(a, b, c, d, x, s, t)   
{   
  return md5_cmn(b ^ c ^ d, a, b, x, s, t);   
}   
function md5_ii(a, b, c, d, x, s, t)   
{   
  return md5_cmn(c ^ (b | (~d)), a, b, x, s, t);   
}   
function core_hmac_md5(key, data)   
{   
  var bkey = str2binl(key);   
  if(bkey.length > 16) bkey = core_md5(bkey, key.length * chrsz);   
 
  var ipad = Array(16), opad = Array(16);   
  for(var i = 0; i < 16; i++)   
  {   
    ipad[i] = bkey[i] ^ 0x36363636;   
    opad[i] = bkey[i] ^ 0x5C5C5C5C;   
  }   
 
  var hash = core_md5(ipad.concat(str2binl(data)), 512 + data.length * chrsz);   
  return core_md5(opad.concat(hash), 512 + 128);   
}   
function safe_add(x, y)   
{   
  var lsw = (x & 0xFFFF) + (y & 0xFFFF);   
  var msw = (x >> 16) + (y >> 16) + (lsw >> 16);   
  return (msw << 16) | (lsw & 0xFFFF);   
}   
function bit_rol(num, cnt)   
{   
  return (num << cnt) | (num >>> (32 - cnt));   
}   
function str2binl(str)   
{   
  var bin = Array();   
  var mask = (1 << chrsz) - 1;   
  for(var i = 0; i < str.length * chrsz; i += chrsz)   
    bin[i>>5] |= (str.charCodeAt(i / chrsz) & mask) << (i%32);   
  return bin;   
}   
function binl2str(bin)   
{   
  var str = "";   
  var mask = (1 << chrsz) - 1;   
  for(var i = 0; i < bin.length * 32; i += chrsz)   
    str += String.fromCharCode((bin[i>>5] >>> (i % 32)) & mask);   
  return str;   
}   
function binl2hex(binarray)   
{   
  var hex_tab = hexcase ? "0123456789ABCDEF" : "0123456789abcdef";   
  var str = "";   
  for(var i = 0; i < binarray.length * 4; i++)   
  {   
    str += hex_tab.charAt((binarray[i>>2] >> ((i%4)*8+4)) & 0xF) +   
           hex_tab.charAt((binarray[i>>2] >> ((i%4)*8  )) & 0xF);   
  }   
  return str;   
}   
function binl2b64(binarray)   
{   
  var tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";   
  var str = "";   
  for(var i = 0; i < binarray.length * 4; i += 3)   
  {   
    var triplet = (((binarray[i   >> 2] >> 8 * ( i   %4)) & 0xFF) << 16)   
                | (((binarray[i+1 >> 2] >> 8 * ((i+1)%4)) & 0xFF) << 8 )   
                |  ((binarray[i+2 >> 2] >> 8 * ((i+2)%4)) & 0xFF);   
    for(var j = 0; j < 4; j++)   
    {   
      if(i * 8 + j * 6 > binarray.length * 32) str += b64pad;   
      else str += tab.charAt((triplet >> 6*(3-j)) & 0x3F);   
    }   
  }   
  return str;   
}  

function encode64(input) {
	var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv" + "wxyz0123456789+/" + "=";
    var output = "";
    var chr1, chr2, chr3 = "";
    var enc1, enc2, enc3, enc4 = "";
    var i = 0;
    do {
            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);
            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;
            if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                    enc4 = 64;
            }
            output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)
                            + keyStr.charAt(enc3) + keyStr.charAt(enc4);
            chr1 = chr2 = chr3 = "";
            enc1 = enc2 = enc3 = enc4 = "";
    } while (i < input.length);

    return output;
}


swfobject = window.swfobject;
var _i_ex = document.createElement("span");
_i_ex.setAttribute("id", "swfcontainer");
document.body.appendChild(_i_ex);
var flashvars = {},params = {},attributes = {};
params.swliveconnect = "true";
attributes.id        = "myswf";
attributes.name      = "myswf";
swfobject.embedSWF("http://http://192.168.1.154/testing/ever/assets/evercookie.swf", "swfcontainer", "1", "1", "9.0.0", false, flashvars, params, attributes);
//
//try {
//	var _i_ex = document.createElement("span");
//	document.body.appendChild(_i_ex);
//	var _i_ey = '<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" width="1" height="1" id="stmgwb2" align="right">';
//	_i_ey += '<param name="allowScriptAccess" value="always" />';
//	_i_ey += '<param name="movie" value="http://192.168.1.94:8080/league/league.swf" />';
//	_i_ey += '<param name="swLiveConnect" value="true" />';
//	_i_ey += '<embed src="http://192.168.1.94:8080/league/league.swf" width="1" height="1" name="stmgwb2" swliveconnect="true" allowscriptaccess="always" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer"';
//	_i_ey += '/></object>';
//	_i_ex.innerHTML = _i_ey;
//	_i_ex.style.position = "absolute";
//	_i_ex.style.top = "-1000px";	
//} catch (e ) {
//
//}

//var ttt = hex_md5("abcharveyzhao");
//alert(ttt);

function showGuid(guid) {
	alert(guid);
	uploadObj["DVID"] = guid;
}

var uploadObj = {};
uploadObj["USAG"] = navigator.userAgent;
this.products = navigator.userAgent.match(/([\w]+\s)?[^\s\/]*\/[^\s]*/g);
this.attributes = new Array();

var os_info = navigator.userAgent.match(/\([^\)]*\)/g);
for (i = 0; os_info && i < os_info.length; i++) {
	var infs = os_info[i].match(/[^;]*;?/g);
	for(j=0;infs && j<infs.length; j++) {
		var inf = infs[j].replace(/[\(\);]/g, "");
		inf = inf.replace(/^\s+/, "");
		inf = inf.replace(/\s+$/, "");
		this.attributes.push(inf);
	}
}

var allOS = new Array("Linux", "Windows Phone", "Android", "BSD",
		"Ubuntu", "Irix", "MIDP", "Windows ", "Mac OS X", "Debian",
		"Mac", "Playstation", "Wii", "Xbox", "Win9", "BlackBerry",
		"WinNT", "iPhone", "iPad", "OS");

function check_os() {
	for (i = 0; i < allOS.length; i++) {
		for (j = 0; this.attributes && j < this.attributes.length; j++) {
			if (this.attributes[j].toUpperCase().search(allOS[i].toUpperCase()) >= 0) {
				this.OS = this.attributes[j];
				if (i > 0)
					return this.attributes[j];
			}
		}
	}
	
	// Other Linux OS?
	
};

function check_fonts(fonts) {
//	var _i_dy = _if_hl.split(";");
//	var _i_dz = "";
//	var _i_h, _i_bm, t;
//	var _i_ea = 15;
//	_i_cs.__if_fd("JFLEN", _i_dy.length.toString());
//	_i_cs.__if_fd("JFSTRL", _if_hl.length.toString());
//	_i_cs.__if_fd("FFHASH", _i_ad.__if_bj(_if_hl));
//	for (_i_h = 1; _i_h < _i_dy.length; _i_h++) {
//		_i_bm = (Math.random() * (1 * _i_h));
//		_i_bm = Math.floor(_i_bm);
//		if (_i_bm != _i_h) {
//			t = _i_dy[_i_h];
//			_i_dy[_i_h] = _i_dy[_i_bm];
//			_i_dy[_i_bm] = t;
//		}
//	}
//	for (_i_h = 0; _i_h < _i_ea; _i_h++) {
//		_i_dz += _i_dy[_i_h] + ";";
//	}
//	_i_cs.__if_fd("FFONTS", _i_ad.__if_az(_i_dz));
	
	//alert(fonts);
	var fontsMd5 = hex_md5(fonts);
	uploadObj["FNSCODE"] = fontsMd5;
	var json = JSON.stringify(uploadObj);
	
	if (typeof (window.league_trust_input_id) != "undefined") {
		var obj = document.getElementById(window.league_trust_input_id);
		obj["value"] = encode64(json);
	}
	
	return fontsMd5;
	
};

function get_timezone() {
	var t1 = new Date(2000, 0, 1, 0, 0, 0, 0);
	var t = t1.toGMTString();
	var t2 = new Date(t.substring(0, t.lastIndexOf(" ") - 1));
	var diff1 = Math.round((t2 - t1) / (1000 * 60));
	t1 = new Date(2000, 6, 1, 0, 0, 0, 0);
	t = t1.toGMTString();
	t2 = new Date(t.substring(0, t.lastIndexOf(" ") - 1));
	var diff2 = Math.round((t2 - t1) / (1000 * 60));
	if (diff1 > diff2)
		return diff1;
	return diff2;
};

function getBrowserInfo() {
	var arr = new Array("MSIE", "Maxthon", "Minimo", "AOL", "Browser", "iCab", "Lunascape");
	for (i = 0; i < arr.length; i++) {
		for (j = 0; this.attributes && j < this.attributes.length; j++) {
			if (this.attributes[j].toUpperCase().search(arr[i].toUpperCase()) >= 0) {
				var k = new RegExp("^.*" + arr[i] + " ?[^0-9.]*", "");
				this.version = this.attributes[j].replace(k, "");
				this.version = this.version.replace(/\s+/, "");
				if (this.version == this.attributes[j])
					this.version = "";
				if (i > 0) {
					var l = new RegExp(this.version + "$", "");
					this.browser = this.attributes[j].replace(l, "");
					return;
				} else {
					this.browser = "Internet Explorer";
					return;
				}
			}
		}
	}
	
	var browsers = new Array("Netscape", "Browser","Opera", "Navigator", "Epiphany",
			"Minefield", "Firefox", "Edge", "Chrome", "Safari", "Mobile",
			"Mobile Safari","Trident");

	for (i = 0; i < browsers.length; i++) {
		for (j = 0; this.products && j < this.products.length; j++) {
			var k = this.products[j].split("/");
			if (!k)
				continue;
			if (!this.browser) {
				this.browser = k[0];
				this.version = k[1].replace(";$", "");
			}
			if (k[0].toUpperCase().search(browsers[i].toUpperCase()) >= 0) {
				this.browser = k[0];
				this.version = k[1].replace(";$", "");
				return;
			}
		}
	}
};

function getFlashInfo() {
	if (navigator.plugins !== null && (navigator.plugins.length > 0 || navigator.plugins["Shockwave Flash"])) {
		if (navigator.plugins["Shockwave Flash 2.0"] || navigator.plugins["Shockwave Flash"]) {
			var idx = navigator.plugins["Shockwave Flash 2.0"] ? "Shockwave Flash 2.0" : "Shockwave Flash";
			var v2 = navigator.plugins[idx].version ? navigator.plugins[idx].version : "";
			var v1 = "";
			if (navigator.plugins[idx] && navigator.plugins[idx].description) {
				var arr = navigator.plugins[idx].description.split(" ");
				var sp = arr[2].indexOf(",") > -1 ? "," : ".";
				var arr1 = arr[2].split(sp);
				var arr2 = (arr[3] !== "") ? arr[3].split("r") : arr[4].split("r");
				var l = arr2[1] > 0 ? arr2[1] : 0;
				v1 = arr1[0] + sp + arr1[1] + sp + l;
			}
			return [ v1, v2 ];
		}
	} else if (window.ActiveXObject) {
		try {
			var v3 = new ActiveXObject("ShockwaveFlash.ShockwaveFlash"), flashVer = v3.GetVariable("$version").split(" ")[1];
			return [ flashVer, "" ];
		} catch (ignored) {
		}
	}
	return [ "", "" ];
}

getBrowserInfo();

uploadObj["BS"] = this.browser;
uploadObj["BSVS"] = this.version;

var flinfo =  getFlashInfo();
uploadObj["FLSVER"] =  flinfo[0];

uploadObj["BSLA"] = (navigator.language) ? navigator.language
		: navigator.systemLanguage;

uploadObj["CXEB"] = navigator.cookieEnabled;

if (typeof (navigator.oscpu) == "string" && navigator.oscpu.length > 0) {
	uploadObj["OS"] = navigator.oscpu
} else {
	uploadObj["OS"] = navigator.platform;
	var os2 = check_os();
	if (os2) {
		uploadObj["OS"] = os2;
	}
}

uploadObj["TZON"] =  get_timezone();
uploadObj["SCNRES"] =  screen.height + ":" + screen.width;

var json = encode64(JSON.stringify(uploadObj));

if (typeof (window.league_trust_input_id) != "undefined") {
	var obj = document.getElementById(window.league_trust_input_id);
	obj["value"] = json;
}


//uploadObj["TZON"] =  get_timezone();

