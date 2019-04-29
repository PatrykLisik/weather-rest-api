import pandas as pd
import requests

data_file_name = "weather-anomalies-1964-2013.csv"
post_address = "http://localhost:8080/entry/"

df = pd.read_csv(data_file_name)

for _, row in df.iterrows():
    date, degrees_from_mean, station_id, longitude, latitudem, max_temp, min_temp, station_name, type, serialid = row
    request_json = {
        "date": date,
        "stationId": station_id,
        "degreesFromMean": degrees_from_mean,
        "longitude": longitude,
        "latitude": latitudem,
        "maxTemp": max_temp,
        "minTemp": min_temp,
        "stationName": station_name,
        "type": type,
        "serialId": serialid
    }
    r = requests.post(post_address, json=request_json)
    if r.status_code != 200:
        print("Request for serialid {} unsuccessful".format(serialid))
