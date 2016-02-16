require 'rubygems'
require 'httparty'
require 'json'

apikey = "e4df4c339dff311d0e1482c26b4192ac328e666a"
venue = "EUADEX"
stock = "PBC"
base_url = "https://api.stockfighter.io/ob/api"

account = "YB62338370"

price = ARGV.shift.to_i

loops = ARGV.shift.to_i

direction = ARGV.shift || "buy"

order = {
  "account" => account,
  "venue" => venue,
  "symbol" => stock,
  "price" => price,  #$250.00 
  "qty" => 500,
  "direction" => direction,
  "orderType" => "limit"  # See the order docs for what a limit order is
}

def limitOrder(base_url, apikey, venue, stock, order)
    response = HTTParty.post("#{base_url}/venues/#{venue}/stocks/#{stock}/orders",
                             :body => JSON.dump(order),
                             :headers => {"X-Starfighter-Authorization" => apikey})
    puts response.body
end

iter = 0

until iter > loops do
    puts "Iteration #{iter}"
    limitOrder(base_url, apikey, venue, stock, order)
    sleep(5)
    iter += 1;
end
