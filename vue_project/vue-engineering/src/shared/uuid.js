export default function getuuid(preix){
    preix = preix || 'yt-'
    return preix + Math.random().toString(36).substr(2, 9); 
}