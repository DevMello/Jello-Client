/**
 * Written by Periklis Master_ex Ntanasis <pntanasis@gmail.com>
 * http://masterex.github.com/
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package me.dev.updater.objects;

/**
 *
 * @author Periklis Ntanasis
 */
public class Release implements Comparable {

    private String pubDate, pkgver, pkgrel, severity, message;

    public String getPubDate() {
        return pubDate;
    }

    public String getpkgver() {
        return pkgver;
    }

    public String getPkgrel() {
        return pkgrel;
    }

    public String getseverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public void setpkgver(String pkgver) {
        this.pkgver = pkgver;
    }

    public void setPkgrel(String pkgrel) {
        this.pkgrel = pkgrel;
    }

    public void setseverity(String severity) {
        this.severity = severity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ("pubDate:\t" + this.pubDate + "\n"
                + "pkgver:\t\t" + this.pkgver + "\n"
                + "pkgrel:\t\t" + this.pkgrel + "\n"
                + "severity:\t" + this.severity + "\n"
                + "message:\t" + this.message);
    }

    @Override
    public int compareTo(Object release) {

        if (this.pkgver.equals(((Release) release).pkgver)) {
            return Integer.parseInt(this.pkgrel) - Integer.parseInt(((Release) release).getPkgrel());
        } else {
            if ((Float.parseFloat(this.pkgver) - Float.parseFloat(((Release) release).getpkgver())) > 0) {
                return 1;
            } else if ((Float.parseFloat(this.pkgver) - Float.parseFloat(((Release) release).getpkgver())) < 0) {
                return -1;
            } else {
                return 0;
            }
        }

    }
}
