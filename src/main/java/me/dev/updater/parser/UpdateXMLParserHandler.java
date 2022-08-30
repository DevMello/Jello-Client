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
package me.dev.updater.parser;
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

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import me.dev.updater.objects.Instruction;

/**
 *
 * @author Periklis Ntanasis
 * @author Jan-Patrick Osterloh (fixed corrupt file names, when list longer than ch buffer)
 */
public class UpdateXMLParserHandler extends DefaultHandler {

    private String currentelement = "";
    private String value = "";
    private ArrayList<Instruction> instructions = new ArrayList<Instruction>();
    private Instruction instruction = new Instruction();

    public UpdateXMLParserHandler() {
        super();
    }

    @Override
    public void startElement(String uri, String name,
                             String qName, Attributes atts) {
        currentelement = qName;
        //ininstruction = true;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {

        //if (ininstruction) {

        if (currentelement.equals("action")) {
            instruction.setAction(value);
        } else if (currentelement.equals("destination")) {
            instruction.setDestination(value);
        } else if (currentelement.equals("file")) {
            instruction.setFilename(value);
        }
        currentelement = "";
        value = "";

        // }
        // ininstruction = false;

        if (qName.equals("instruction")) {
            instructions.add(instruction);
            instruction = new Instruction();
            currentelement = "";
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        if (!currentelement.equals("")) {
            value += String.copyValueOf(ch, start, length).trim();
        }

    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }
}

