//
// XMLIndent.java
//

/*
OME Bio-Formats package for reading and converting biological file formats.
Copyright (C) 2005-@year@ UW-Madison LOCI and Glencoe Software, Inc.

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package loci.formats.tools;

import java.io.*;
import loci.formats.XMLTools;

/**
 * Indents XML to be more readable.
 *
 * <dl><dt><b>Source code:</b></dt>
 * <dd><a href="https://skyking.microscopy.wisc.edu/trac/java/browser/trunk/loci/formats/tools/IndentXML.java">Trac</a>,
 * <a href="https://skyking.microscopy.wisc.edu/svn/java/trunk/loci/formats/tools/IndentXML.java">SVN</a></dd></dl>
 */
public class XMLIndent {

  public static void process(BufferedReader in) throws IOException {
    StringBuffer sb = new StringBuffer();
    while (true) {
      String line = in.readLine();
      if (line == null) break;
      sb.append(line);
    }
    in.close();
    System.out.println(XMLTools.indentXML(sb.toString()));
  }

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      // read from stdin
      process(new BufferedReader(new InputStreamReader(System.in)));
    }
    else {
      // read from file(s)
      for (int i=0; i<args.length; i++) {
        process(new BufferedReader(new FileReader(args[i])));
      }
    }
  }

}
