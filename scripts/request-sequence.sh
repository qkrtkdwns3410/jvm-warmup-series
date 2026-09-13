#!/usr/bin/env bash
set -euo pipefail

base_url="${1:-http://localhost:8080}"
for path in cpu serialization database mixed; do
  echo "== $path =="
  for attempt in 1 2 10 100; do
    if (( attempt > 2 )); then
      for ((i=3; i<=attempt; i++)); do curl -fsS "$base_url/experiments/$path" >/dev/null; done
    fi
    curl -fsS -o /dev/null -w "request=$attempt total=%{time_total}s\n" "$base_url/experiments/$path"
  done
done
