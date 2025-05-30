#!/usr/bin/env ruby
module HTMLText
  def source
    raise 'Not implemented'
  end

  def to_s
    source
  end
end

class PlainText
  include HTMLText

  attr_writer :content

  def initialize(content)
    @content = content
  end

  def source
    @content
  end

  attr_reader :content
end


# Estos text solo van a usar source o to_s
class NotLink
  def initialize(html_text)
    raise 'Abstract class, cannot be initialized'
  end

  def source(tag)
    "<#{tag}>#{@text.source}</#{tag}>"
  end
end

class BoldText < NotLink
  TAG = 'b'

  def initialize(html_text)
    @text = html_text
  end

  def source
    super(TAG)
  end

  alias_method :to_s, :source
end

class ItalicText < NotLink
  TAG = 'i'

  def initialize(html_text)
    @text = html_text
  end

  def source
    super(TAG)
  end

  alias_method :to_s, :source
end

# Este text solo va a usar source o to_s
class LinkText
  TAG = 'a'

  def initialize(html_text, href)
    @text = html_text
    @ref = href
  end

  def source
    "<#{TAG} href:\"#{@ref}\">#{@text.source}</#{TAG}>"
  end

  alias_method :to_s, :source
end

text = PlainText.new 'Hola'
bold_text = BoldText.new text
italic_text = ItalicText.new text
puts bold_text # <b>Hola</b>
puts italic_text # <i>Hola</i>
bold_italic_text = BoldText.new italic_text
puts bold_italic_text # <b><i>Hola</i></b>
text.content = 'ITBA'
puts bold_text # <b>ITBA</b>
puts italic_text # <i>ITBA</i>
puts bold_italic_text # <b><i>ITBA</i></b>
link_text = LinkText.new(text, 'www.itba.edu.ar')
link_bold_italic_text = LinkText.new(bold_italic_text, 'www.itba.edu.ar')
bold_link_text = BoldText.new link_text
puts link_text # <a href:"www.itba.edu.ar">ITBA</a>
puts link_bold_italic_text # <a href:"www.itba.edu.ar"><b><i>ITBA</i></b></a>
puts bold_link_text # <b><a href:"www.itba.edu.ar">ITBA</a></b>
text.content = 'Ejemplo'
puts link_bold_italic_text # <a href:"www.itba.edu.ar"><b><i>Ejemplo</i></b></a>
puts bold_link_text # <b><a href:"www.itba.edu.ar">Ejemplo</a></b>
